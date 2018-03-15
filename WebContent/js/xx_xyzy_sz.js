      $(function () {
    	  
    	  $.ajax({
    	    	type: "post",  
    	            url: "/sxunivw/Xyxxup",
    	    	success: function (data) {
    		        for (var i = 0; i < data.length; i++) {
    		            $('#txt_xyxm').append("<option value=" + data[i].xydm + ">" + data[i].xymc + "</option>");
    		        }
    		        $('#txt_xyxm').selectpicker('refresh');
    		        $('#txt_xyxm').selectpicker('render');
    	    }
    	});
    	  
    	  toastr.options = {  
    		        closeButton: false,  
    		        debug: false,  
    		        progressBar: true,  
//    		        positionClass: "toast-top-center",  
    		        onclick: null,  
    		        showDuration: "300",  
    		        hideDuration: "1000",  
    		        timeOut: "2000",  
    		        extendedTimeOut: "1000",  
    		        showEasing: "swing",  
    		        hideEasing: "linear",  
    		        showMethod: "fadeIn",  
    		        hideMethod: "fadeOut"  
    		    }; 
		  
    	       
    	        
    	   
    	        
    	    	$("#btn_add1").click(function () {  

    	           $('#myModal1').modal()

    	       });
    	    	

    			
    	        $("#btn_delete").click(function () {
    	            var arrselections = $("#tb_departments").bootstrapTable('getSelections');
    	             if (arrselections.length <= 0) {
    	                toastr.warning('请选择有效数据');
    	                return;
    	             }
    	             Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
    	                 if (!e) {
    	                     return;
    	                 }
    	                 $.ajax({
    	                     type: "post",
    	                     url:"/sxunivw/Xxxyzysz",
    	                     data: {                     	
    	                     	"zyidxlshs":arrselections[0].zyidxlsh,
    	                     	"xydm":arrselections[0].xydm,
    	                     	"id":2
    	                     },
    	                     success: function (data, status) {
    	                         if (status == "success") {
    	                            toastr.success('提交数据成功');
    	                            $("#tb_departments").bootstrapTable('refresh');
    	                         }
    	                     },
    	                     error: function () {
    	                         toastr.error('删除失败');
    	                     },
    	                     complete: function () {

    	                     }

    	               });
    	             });
    	         });

    	        $("#btn_submit1").click(function () {
         	        	var xyxm = $("#txt_xyxm").val();
        	            var zylb = $("#txt_zylb").val();
        	            var zylsh = $("#txt_sanjizy").val();
        	            if(xyxm == null || xyxm == undefined || xyxm == ''){
        	            	toastr.error('学院不能为空');
        	            }else{
        	            	if(zylb == null || zylb == undefined || zylb == ''){
        	            		toastr.error('专业类别不能为空');
        	            	}else{
        	            		if(zylsh == null || zylsh == undefined || zylsh == ''){
        	            			toastr.error('专业不能为空');
        	            		}else{
        	        	            $.ajax({
        	        	                type: "post",
        	        	                url: "/sxunivw/Xxxyzysz",
        	        	                data: { 
        	        	                	"xydm":xyxm,
        	        	                	"zylb":zylb,
        	        	                	"zylsh":zylsh,
        	        	                	"id":1,
        	        	                	},
        	        	                success: function (data, status) {
        	        	                    if (status == "success") {
        	        	                        toastr.success('提交数据成功');
        	        	                        $("#tb_departments").bootstrapTable('refresh');
        	        	                    }
        	        	                },
        	        	                error: function () {
        	        	                    toastr.error('提交数据失败或数据已存在');
        	        	                },
        	        	                complete: function () {
        	        	                	$('#myModal1').modal('hide'); 
        	        	                }
        	        	            });
        	            			
        	            		}
        	            	}
        	            }
    	        });
    	        


    	        var oTable = new TableInit();
    	        oTable.Init();

});
      
      var TableInit = function () {
    	    var oTableInit = new Object();
    	    //初始化Table
    	    oTableInit.Init = function () {
    	        $('#tb_departments').bootstrapTable({
    	            url: '/sxunivw/Xxxyzysz',         //请求后台的URL（*）
    	            method: 'post',                      //请求方式（*）
    	            toolbar: '#toolbar',                //工具按钮用哪个容器
    	            striped: true,                      //是否显示行间隔色
    	            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
    	            pagination: true,                   //是否显示分页（*）
    	            sortable: false,                     //是否启用排序
    	            sortOrder: "asc",                   //排序方式
    	            queryParams: oTableInit.queryParams,//传递参数（*）
    	            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
    	            pageNumber:1,                       //初始化加载第一页，默认第一页
    	            pageSize: 15,                       //每页的记录行数（*）
    	            pageList: [15],        //可供选择的每页的行数（*）
//    	            showRefresh: true,
    	            singleSelect  : true, //单选
    	            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
    	            showColumns: true,                  //是否显示所有的列
    	            minimumCountColumns: 2,             //最少允许的列数
    	            showExport: true,                     //是否显示导出
    	            exportDataType: "basic",              //basic', 'all', 'selected'.
    	            clickToSelect: true,                //是否启用点击选中行
    	            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
    	            uniqueId: "xxxm",                     //每一行的唯一标识，一般为主键列
    	            columns: [{
    	                  checkbox: true
    	              }, {
    	                  field: 'xyxm',
    	                  title: '学院名称'
    	              },{
    	                  field: 'zylb',
    	                  title: '专业类别'
    	              }, {
    	                  field: 'yijizy',
    	                  title: '一级专业'
    	              }, {
    	                  field: 'erjizy',
    	                  title: '二级专业'
    	              } ,{
    	                  field: 'sanjizy',
    	                  title: '三级专业'
    	              },],
    	        });
    	    };

    	    return oTableInit;
    	};


    	function zylb() {  
    	    var zydm=$("#txt_zylb").val();
    	        if(zydm==2){
    	        	$("#txt_yijizy").empty();
    	        	$('#txt_yijizy').selectpicker('refresh');
    	        	$("#txt_yijizy").append($("<option >" +' - 请选择 - '+ "</option>"));
    	        	$("#txt_erjizy").empty();
    	        	$('#txt_erjizy').selectpicker('refresh');
    	        	$("#txt_sanjizy").empty();
    	        	$('#txt_sanjizy').selectpicker('refresh');
    	        	$.ajax({
    	    	    	type: "post",  
    	    	            url: "/sxunivw/Sanjifind",
    						data:{
    	    	            	"id":1
    	    	            },
    	    	    	success: function (data) {
    	    	    		
    	    		        for (var i = 0; i < data.length; i++) {
    	 
    	    		            $('#txt_yijizy').append("<option value=" + data[i].yijidm + ">" + data[i].yijmc + "</option>");
    	    		        }
    	    		        $('#txt_yijizy').selectpicker('refresh');
    	    		        $('#txt_yijizy').selectpicker('render');
    	    	    }
    	    	});
    	        }
    	        
    	        if(zydm==1){
    	        	$("#txt_yijizy").empty();
    	        	$('#txt_yijizy').selectpicker('refresh');
    	        	$("#txt_yijizy").append($("<option >" +' - 请选择 - '+ "</option>"));
    	        	$("#txt_erjizy").empty();
    	        	$('#txt_erjizy').selectpicker('refresh');
    	        	$("#txt_sanjizy").empty();
    	        	$('#txt_sanjizy').selectpicker('refresh');
    	        	$.ajax({
    	    	    	type: "post",  
    	    	            url: "/sxunivw/Sanjifind",
    						data:{
    	    	            	"id":4
    	    	            },
    	    	    	success: function (data) {

    	    		        for (var i = 0; i < data.length; i++) {
    	    		            $('#txt_yijizy').append("<option value=" + data[i].yijidm + ">" + data[i].yijimc + "</option>");
    	    		        }
    	    		        $('#txt_yijizy').selectpicker('refresh');
    	    		        $('#txt_yijizy').selectpicker('render');
    	    	    }
    	    	});
        	  }
    	    } 
    	
    	function yijizy() {  
    	    var zydm=$("#txt_zylb").val();
    	    var zydm1=$("#txt_yijizy").val();
    	 
    	        if(zydm==2){
    	        	$("#txt_erjizy").empty();
    	         	$('#txt_erjizy').selectpicker('refresh');
    	         	$("#txt_erjizy").append($("<option >" +' - 请选择 - '+ "</option>"));
    	        	$("#txt_sanjizy").empty();
    	         	$('#txt_sanjizy').selectpicker('refresh');
    	        	$.ajax({
    	    	    	type: "post",  
    	    	            url: "/sxunivw/Sanjifind",
    						data:{
    							"zydm1":zydm1,
    	    	            	"id":2
    	    	            },
    	    	    	success: function (data) {

    	    		        for (var i = 0; i < data.length; i++) {
    	    		            $('#txt_erjizy').append("<option value=" + data[i].erjidm + ">" + data[i].erjmc + "</option>");
    	    		        }
    	    		        $('#txt_erjizy').selectpicker('refresh');
    	    		        $('#txt_erjizy').selectpicker('render');
    	    	    }
    	    	});
    	        }
    	        
    	        if(zydm==1){
    	        	$("#txt_erjizy").empty();
    	         	$('#txt_erjizy').selectpicker('refresh');
    	        	$("#txt_erjizy").append($("<option >" +' - 请选择 - '+ "</option>"));
    	        	$("#txt_sanjizy").empty();
    	         	$('#txt_sanjizy').selectpicker('refresh');
    	        	$.ajax({
    	    	    	type: "post",  
    	    	            url: "/sxunivw/Sanjifind",
    						data:{
    							"zydm1":zydm1,
    	    	            	"id":5
    	    	            },
    	    	    	success: function (data) {

    	    		        for (var i = 0; i < data.length; i++) {
    	    		            $('#txt_erjizy').append("<option value=" + data[i].erjidm + ">" + data[i].erjdmmc + "</option>");
    	    		        }
    	    		        $('#txt_erjizy').selectpicker('refresh');
    	    		        $('#txt_erjizy').selectpicker('render');
    	    	    }
    	    	});
        	  }
    	    } 
    	
    	function erjizy() {  
    	    var zydm=$("#txt_zylb").val();
    	    var zydm1=$("#txt_erjizy").val();
    	        if(zydm==2){
    	        	$("#txt_sanjizy").empty();
    	        	$("#txt_sanjizy").append($("<option >" +' - 请选择 - '+ "</option>"));
    	        	$.ajax({
    	    	    	type: "post",  
    	    	            url: "/sxunivw/Sanjifind",
    						data:{
    							"zydm1":zydm1,
    	    	            	"id":3
    	    	            },
    	    	    	success: function (data) {

    	    		        for (var i = 0; i < data.length; i++) {
    	    		            $('#txt_sanjizy').append("<option value=" + data[i].zyidlsh + ">" + data[i].sanjmc + "</option>");
    	    		        }
    	    		        $('#txt_sanjizy').selectpicker('refresh');
    	    		        $('#txt_sanjizy').selectpicker('render');
    	    	    }
    	    	});
    	        }
    	        
    	        if(zydm==1){
    	        	$("#txt_sanjizy").empty();
    	        	$("#txt_sanjizy").append($("<option >" +' - 请选择 - '+ "</option>"));
    	        	$.ajax({
    	    	    	type: "post",  
    	    	            url: "/sxunivw/Sanjifind",
    						data:{
    							"zydm1":zydm1,
    	    	            	"id":6
    	    	            },
    	    	    	success: function (data) {

    	    		        for (var i = 0; i < data.length; i++) {
    	    		            $('#txt_sanjizy').append("<option value=" + data[i].zyidlsh + ">" + data[i].sanjmc + "</option>");
    	    		        }
    	    		        $('#txt_sanjizy').selectpicker('refresh');
    	    		        $('#txt_sanjizy').selectpicker('render');
    	    	    }
    	    	});
        	  }
    	    } 
    	
  
        
        
        (function ($) {
        	 
        	  window.Ewin = function () {
        	    var html = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">' +
        	               '<div class="modal-dialog modal-sm">' +
        	                 '<div class="modal-content">' +
        	                   '<div class="modal-header">' +
        	                     '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>' +
        	                     '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
        	                   '</div>' +
        	                   '<div class="modal-body">' +
        	                   '<p>[Message]</p>' +
        	                   '</div>' +
        	                    '<div class="modal-footer">' +
        	    '<button type="button" class="btn btn-default cancel" data-dismiss="modal">[BtnCancel]</button>' +
        	    '<button type="button" class="btn btn-primary ok" data-dismiss="modal">[BtnOk]</button>' +
        	  '</div>' +
        	                 '</div>' +
        	               '</div>' +
        	             '</div>';
        	 
        	 
        	    var dialogdHtml = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">' +
        	               '<div class="modal-dialog">' +
        	                 '<div class="modal-content">' +
        	                   '<div class="modal-header">' +
        	                     '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>' +
        	                     '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
        	                   '</div>' +
        	                   '<div class="modal-body">' +
        	                   '</div>' +
        	                 '</div>' +
        	               '</div>' +
        	             '</div>';
        	    var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
        	    var generateId = function () {
        	      var date = new Date();
        	      return 'mdl' + date.valueOf();
        	    }
        	    var init = function (options) {
        	      options = $.extend({}, {
        	        title: "操作提示",
        	        message: "提示内容",
        	        btnok: "确定",
        	        btncl: "取消",
        	        width: 200,
        	        auto: false
        	      }, options || {});
        	      var modalId = generateId();
        	      var content = html.replace(reg, function (node, key) {
        	        return {
        	          Id: modalId,
        	          Title: options.title,
        	          Message: options.message,
        	          BtnOk: options.btnok,
        	          BtnCancel: options.btncl
        	        }[key];
        	      });
        	      $('body').append(content);
        	      $('#' + modalId).modal({
        	        width: options.width,
        	        backdrop: 'static'
        	      });
        	      $('#' + modalId).on('hide.bs.modal', function (e) {
        	        $('body').find('#' + modalId).remove();
        	      });
        	      return modalId;
        	    }
        	 
        	    return {
        	      alert: function (options) {
        	        if (typeof options == 'string') {
        	          options = {
        	            message: options
        	          };
        	        }
        	        var id = init(options);
        	        var modal = $('#' + id);
        	        modal.find('.ok').removeClass('btn-success').addClass('btn-primary');
        	        modal.find('.cancel').hide();
        	 
        	        return {
        	          id: id,
        	          on: function (callback) {
        	            if (callback && callback instanceof Function) {
        	              modal.find('.ok').click(function () { callback(true); });
        	            }
        	          },
        	          hide: function (callback) {
        	            if (callback && callback instanceof Function) {
        	              modal.on('hide.bs.modal', function (e) {
        	                callback(e);
        	              }); 
        	            }
        	          }
        	        };
        	      },
        	      confirm: function (options) {
        	        var id = init(options);
        	        var modal = $('#' + id);
        	        modal.find('.ok').removeClass('btn-primary').addClass('btn-success');
        	        modal.find('.cancel').show();
        	        return {
        	          id: id,
        	          on: function (callback) {
        	            if (callback && callback instanceof Function) {
        	              modal.find('.ok').click(function () { callback(true); });
        	              modal.find('.cancel').click(function () { callback(false); });
        	            }
        	          },
        	          hide: function (callback) {
        	            if (callback && callback instanceof Function) {
        	              modal.on('hide.bs.modal', function (e) {
        	                callback(e);
        	              });
        	            }
        	          }
        	        };
        	      },
        	      dialog: function (options) {
        	        options = $.extend({}, {
        	          title: 'title',
        	          url: '',
        	          width: 800,
        	          height: 550,
        	          onReady: function () { },
        	          onShown: function (e) { }
        	        }, options || {});
        	        var modalId = generateId();
        	 
        	        var content = dialogdHtml.replace(reg, function (node, key) {
        	          return {
        	            Id: modalId,
        	            Title: options.title
        	          }[key];
        	        });
        	        $('body').append(content);
        	        var target = $('#' + modalId);
        	        target.find('.modal-body').load(options.url);
        	        if (options.onReady())
        	          options.onReady.call(target);
        	        target.modal();
        	        target.on('shown.bs.modal', function (e) {
        	          if (options.onReady(e))
        	            options.onReady.call(target, e);
        	        });
        	        target.on('hide.bs.modal', function (e) {
        	          $('body').find(target).remove();
        	        });
        	      }
        	    }
        	  }();
        	})(jQuery);
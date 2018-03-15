      $(function () {
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
    	  
    		  $('#txt_chenlinian').datetimepicker({
    			  format: 'yyyy',
    		      weekStart: 1,
    		      autoclose: true,
    		      startView: 4,
    		      minView: 4,
    		      forceParse: false,
    		      language: 'zh-CN'
    			}).on('hide',function(e) {
                $('#defaultForm').data('bootstrapValidator')  
                    .updateStatus('txt_chenlinian', 'NOT_VALIDATED',null)  
                    .validateField('txt_chenlinian');  
            });  
    		  
    	        $('#defaultForm').bootstrapValidator({
    	            message: '不可用',
    	            feedbackIcons: {
    	                valid: 'glyphicon glyphicon-ok',
    	                invalid: 'glyphicon glyphicon-remove',
    	                validating: 'glyphicon glyphicon-refresh'
    	            },   	               	            
    	            fields: {
    	                txt_jxdwmc: {
    	                    message: '教学单位名称验证失败',
    	                    validators: {
    	                        notEmpty: {
    	                            message: '不能为空'
    	                        },
    	                        stringLength: {
    	                            max: 30,
    	                            message: '长度必须小于30'
    	                        }
    	                    }
    	                },
    	                txt_chenlinian: {
    	                    message: '成立年分验证失败',
    	                    validators: {
    	                        notEmpty: {
    	                            message: '不能为空'
    	                        }
    	                    }
    	                },
    	                txt_lxr: {
    	                    message: '联系人验证失败',
    	                    validators: {
    	                        notEmpty: {
    	                            message: '不能为空'
    	                        },
    	                        stringLength: {
    	                            max: 10,
    	                            message: '长度必须小于10'
    	                        }
    	                    }
    	                },
    	                txt_lxdh: {
    	                    message: '联系电话验证失败',
    	                    validators: {
    	                        notEmpty: {
    	                            message: '不能为空'
    	                        },
    	                        stringLength: {
    	                            max: 40,
    	                            message: '长度必须小于20'
    	                        }
    	                    }
    	                },	   
    	            },
    	           
    	        });
    	        
    	    	$("#btn_add").click(function () {
    	    		 $('#defaultForm').data('bootstrapValidator').resetForm(true);
    	            $("#myModalLabel").text("新增");
//    	            $("#myModal").find(".form-control").val("");
    	            document.getElementById('btn_submit').value='1'
    	           $("#txt_xydm").val('系统自动生成');
    	           $('#myModal').modal()

    	       });
    			
    			$("#btn_edit").click(function () {
    	            var arrselections = $("#tb_departments").bootstrapTable('getSelections');
    	           if (arrselections.length > 1) {
    	               toastr.warning('只能选择一行进行编辑');

    	                return;
    	         }
    	            if (arrselections.length <= 0) {
    	                toastr.warning('请选择有效数据');

    	                return;
    	            }
    	   
    	            $("#myModalLabel").text("修改");
    	           $("#txt_jxdwmc").val(arrselections[0].xymc);
    	           $("#txt_chenlinian").val(arrselections[0].chenlinian);
    	            $("#txt_lxr").val(arrselections[0].lxr);
    	            $("#txt_lxdh").val(arrselections[0].lxrdh);
    	            $("#txt_xydm").val(arrselections[0].xydm);
    	            document.getElementById('btn_submit').value='2'
    	            	
    	            $('#myModal').modal();
    	        });
    			
    	        $("#btn_delete").click(function () {
    	            var arrselections = $("#tb_departments").bootstrapTable('getSelections');
    	             if (arrselections.length <= 0) {
    	                toastr.warning('请选择有效数据');
    	                return;
    	             }
    	             var xydms = toString();
    	             Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
    	                 if (!e) {
    	                     return;
    	                 }
    	                 $.ajax({
    	                     type: "post",
    	                     url:"/sxunivw/Xyxxup",
    	                     data: {                     	
    	                     	"xydms":xydms,
    	                     	"id":3
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
    	        
    	        $("#defaultForm").submit(function(ev){ev.preventDefault();});
    	        $("#btn_submit").click(function () {
    	        var bootstrapValidator = $("#defaultForm").data('bootstrapValidator');
         	        bootstrapValidator.validate();
         	        if(bootstrapValidator.isValid()){
         	        	
         	        	var id=document.getElementById('btn_submit').value;
        	            var jxdwmc = $("#txt_jxdwmc").val();
        	            var clnf = $("#txt_chenlinian").val();
        	            var lxr = $("#txt_lxr").val();
        	            var lxdh = $("#txt_lxdh").val();
        	            var xydm = $("#txt_xydm").val();
        	            $.ajax({
        	                type: "post",
        	                url: "/sxunivw/Xyxxup",
        	                data: { 
        	                	"jxdwmc":jxdwmc,
        	                	"clnf":clnf,
        	                	"lxr":lxr,
        	                	"lxdh":lxdh,
        	                	"id":id,
        	                	"xydm":xydm
        	                	},
        	                success: function (data, status) {
        	                    if (status == "success") {
        	                        toastr.success('提交数据成功');
        	                        $("#tb_departments").bootstrapTable('refresh');
        	                    }
        	                },
        	                error: function () {
        	                    toastr.error('提交数据失败');
        	                },
        	                complete: function () {
        	                	$('#myModal').modal('hide'); 
        	                	 $('#defaultForm').data('bootstrapValidator').resetForm(true);

        	                }

        	            });
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
    	            url: '/sxunivw/Xyxxup',         //请求后台的URL（*）
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
    	            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
    	            showColumns: true,                  //是否显示所有的列
    	            minimumCountColumns: 2,             //最少允许的列数
    	            showExport: true,                     //是否显示导出
    	            exportDataType: "basic",              //basic', 'all', 'selected'.
    	            clickToSelect: true,                //是否启用点击选中行
    	            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
    	            uniqueId: "xymc",                     //每一行的唯一标识，一般为主键列
    	            columns: [{
    	                  checkbox: true
    	              }, {
    	                  field: 'xymc',
    	                  title: '学院名称'
    	              }, {
    	                  field: 'xydm',
    	                  title: '学院代码'
    	              }, {
    	                  field: 'chenlinian',
    	                  title: '成立时间'
    	              } ,{
    	                  field: 'lxr',
    	                  title: '联系人'
    	              },{
    	                  field: 'lxrdh',
    	                  title: '联系电话'
    	              },{
    	                  field: 'xxdm',
    	                  title: '学校代码'
    	              },],
    	        });
    	    };

    	    return oTableInit;
    	};


	
        
        function toString (){
        	var arrselections = $("#tb_departments").bootstrapTable('getSelections');
        	var xydms = "";
        	for(var i=0;i<arrselections.length;i++){
        		if(i==0){
        			xydms = arrselections[i].xydm;
        		}else{
        			xydms = xydms +","+arrselections[i].xydm;
        		}
        	}
        	return xydms;
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
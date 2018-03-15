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
		  
    	        $('#defaultForm1').bootstrapValidator({
    	            message: '不可用',
    	            feedbackIcons: {
    	                valid: 'glyphicon glyphicon-ok',
    	                invalid: 'glyphicon glyphicon-remove',
    	                validating: 'glyphicon glyphicon-refresh'
    	            },   	               	            
    	            fields: {
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
    	                            max: 20,
    	                            message: '长度必须小于20'
    	                        }
    	                    }
    	                },	   
    	            },
    	           
    	        });
    	        
    	        $('#defaultForm2').bootstrapValidator({
    	            message: '不可用',
    	            feedbackIcons: {
    	                valid: 'glyphicon glyphicon-ok',
    	                invalid: 'glyphicon glyphicon-remove',
    	                validating: 'glyphicon glyphicon-refresh'
    	            },   	               	            
    	            fields: {
    	                txt_lxr1: {
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
    	                txt_lxdh1: {
    	                    message: '联系电话验证失败',
    	                    validators: {
    	                        notEmpty: {
    	                            message: '不能为空'
    	                        },
    	                        stringLength: {
    	                            max: 20,
    	                            message: '长度必须小于20'
    	                        }
    	                    }
    	                },	
    	                txt_xxxm1: {
    	                    message: '学校姓名验证失败',
    	                    validators: {
    	                        notEmpty: {
    	                            message: '不能为空'
    	                        }
    	                    }
    	                },	
    	            },
    	           
    	        });
    	        
    	        $('#defaultForm3').bootstrapValidator({
    	            message: '不可用',
    	            feedbackIcons: {
    	                valid: 'glyphicon glyphicon-ok',
    	                invalid: 'glyphicon glyphicon-remove',
    	                validating: 'glyphicon glyphicon-refresh'
    	            },   	               	            
    	            fields: {
    	                txt_lxr3: {
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
    	                txt_lxdh3: {
    	                    message: '联系电话验证失败',
    	                    validators: {
    	                        notEmpty: {
    	                            message: '不能为空'
    	                        },
    	                        stringLength: {
    	                            max: 20,
    	                            message: '长度必须小于20'
    	                        }
    	                    }
    	                },	   
    	            },
    	           
    	        });
    	        
    	    	$("#btn_add1").click(function () {  
    	    	

    	           $('#myModal1').modal()

    	       });
    	    	$("#btn_add2").click(function () {
    	    	
    	    		 
    	           $('#myModal2').modal()

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
    	           $("#txt_xxxm3").val(arrselections[0].xxxm);
    	           $("#txt_lxr3").val(arrselections[0].czyxm);
    	            $("#txt_czygh3").val(arrselections[0].czyzgh);
    	            $("#txt_czykl3").val(arrselections[0].czykl);
    	            $("#txt_lxdh3").val(arrselections[0].lxdh);
    	            $('#myModal3').modal();
    	        });
    			
    	        $("#btn_delete").click(function () {
    	            var arrselections = $("#tb_departments").bootstrapTable('getSelections');
    	             if (arrselections.length <= 0) {
    	                toastr.warning('请选择有效数据');
    	                return;
    	             }
    	             var czyzghs = toString();
    	             Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
    	                 if (!e) {
    	                     return;
    	                 }
    	                 $.ajax({
    	                     type: "post",
    	                     url:"/sxunivw/Xxczygl",
    	                     data: {                     	
    	                     	"czyzghs":czyzghs,
    	                     	"id":4
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
    	        
    	        $("#defaultForm1").submit(function(ev){ev.preventDefault();});
    	        $("#btn_submit1").click(function () {
    	        var bootstrapValidator = $("#defaultForm1").data('bootstrapValidator');
         	        bootstrapValidator.validate();
         	        if(bootstrapValidator.isValid()){
   
        	            var lxr = $("#txt_lxr").val();
        	            var lxdh = $("#txt_lxdh").val();
        	            $.ajax({
        	                type: "post",
        	                url: "/sxunivw/Xxczygl",
        	                data: { 
        	                	"lxr":lxr,
        	                	"lxdh":lxdh,
        	                	"id":1,
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
        	                	$('#myModal1').modal('hide'); 
        	                	 $('#defaultForm1').data('bootstrapValidator').resetForm(true);

        	                }

        	            });
         	        }
	
    	        });
    	        
    	        $("#defaultForm2").submit(function(ev){ev.preventDefault();});
    	        $("#btn_submit2").click(function () {
    	        var bootstrapValidator = $("#defaultForm2").data('bootstrapValidator');
         	        bootstrapValidator.validate();
         	        if(bootstrapValidator.isValid()){
         	        	var xydm=$("#txt_xyxm").val();
        	            var lxr = $("#txt_lxr1").val();
        	            var lxdh = $("#txt_lxdh1").val();
 
        	            $.ajax({
        	                type: "post",
        	                url: "/sxunivw/Xxczygl",
        	                data: { 
        	                	"xydm":xydm,     	 
        	                	"lxr":lxr,
        	                	"lxdh":lxdh,
        	                	"id":2,
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
        	                	$('#myModal2').modal('hide'); 
        	                	 $('#defaultForm2').data('bootstrapValidator').resetForm(true);

        	                }

        	            });
         	        }
	
    	        });
    	        
    	        $("#defaultForm3").submit(function(ev){ev.preventDefault();});
    	        $("#btn_submit3").click(function () {
    	        var bootstrapValidator = $("#defaultForm3").data('bootstrapValidator');
         	        bootstrapValidator.validate();
         	        if(bootstrapValidator.isValid()){

        	            var lxr = $("#txt_lxr3").val();
        	            var lxdh = $("#txt_lxdh3").val();
        	            var czygh = $("#txt_czygh3").val();
        	            $.ajax({
        	                type: "post",
        	                url: "/sxunivw/Xxczygl",
        	                data: {      	 
        	                	"lxr":lxr,
        	                	"lxdh":lxdh,
        	                	"czygh":czygh,
        	                	"id":3
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
        	                	$('#myModal3').modal('hide'); 
        	                	 $('#defaultForm3').data('bootstrapValidator').resetForm(true);

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
    	            url: '/sxunivw/Xxczygl',         //请求后台的URL（*）
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
    	            uniqueId: "xxxm",                     //每一行的唯一标识，一般为主键列
    	            columns: [{
    	                  checkbox: true
    	              }, {
    	                  field: 'xxxm',
    	                  title: '学校名称'
    	              }, {
    	                  field: 'czyzgh',
    	                  title: '操作员工作号'
    	              }, {
    	                  field: 'czykl',
    	                  title: '操作员口令'
    	              } ,{
    	                  field: 'czyxm',
    	                  title: '操作员'
    	              },{
    	                  field: 'lxdh',
    	                  title: '联系电话'
    	              },{
    	                  field: 'czyzl',
    	                  title: '操作员类别'
    	              },{
    	                  field: 'xyxm',
    	                  title: '管理的学院'
    	              },],
    	        });
    	    };

    	    return oTableInit;
    	};


	
        
        function toString (){
        	var arrselections = $("#tb_departments").bootstrapTable('getSelections');
        	var czyzghs = "";
        	for(var i=0;i<arrselections.length;i++){
        		if(i==0){
        			czyzghs = arrselections[i].czyzgh;
        		}else{
        			czyzghs = czyzghs +","+arrselections[i].czyzgh;
        		}
        	}
        	return czyzghs;
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
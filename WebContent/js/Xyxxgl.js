      $(function () {
    	  
    	        $('#defaultForm1').bootstrapValidator({
    	            message: '不可用',
    	            feedbackIcons: {
    	                valid: 'glyphicon glyphicon-ok',
    	                invalid: 'glyphicon glyphicon-remove',
    	                validating: 'glyphicon glyphicon-refresh'
    	            },   	               	            
    	            fields: {
    	            	xyxm: {
    	                    message: '校友姓名验证失败',
    	                    validators: {
    	                        notEmpty: {
    	                            message: '不能为空'
    	                        },
    	                        stringLength: {
    	                            max: 10,
    	                            message: '长度必须小于10个字符'
    	                        }
    	                    }
    	                },
    	                xb: {
    	                    message: '验证失败',
    	                    validators: {
    	                        notEmpty: {
    	                            message: '不能为空'
    	                        }
    	                    }
    	                },	 
    	                rxnf: {
    	                    message: '验证失败',
    	                    validators: {
    	                        notEmpty: {
    	                            message: '不能为空'
    	                        }
    	                    }
    	                },
    	                gzdw: {
    	                    message: '验证失败',
    	                    validators: {
    	                        notEmpty: {
    	                            message: '不能为空'
    	                        },
    	                        stringLength: {
    	                            max: 30,
    	                            message: '长度必须小于30个字符'
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
    	          
    	            },
    	           
    	        });
    	        $("#btn_add").click(function () {
    	          	hyyijidm();
    	          	$("#btn_submit1").val("1");
    	            $('#myModal1').modal();
    	        });
    	        
    	    	$("#btn_edit").click(function () {
    	            $('#myModal1').modal();
    	            var arrselections = $("#tb_departments").bootstrapTable('getSelections');
    	           if (arrselections.length > 1) {
    	               toastr.warning('只能选择一行进行编辑');

    	                return;
    	         }
    	            if (arrselections.length <= 0) {
    	                toastr.warning('请选择有效数据');

    	                return;
    	            }
    	        	$("#btn_submit1").val("2");
    	            $("#id").val(arrselections[0].ID);
    	            $("#xyxm").val(arrselections[0].XM);
    	           	$("#xb").val(arrselections[0].XB);
    	           	$("#rxnf").val(arrselections[0].RXNF);
    	          	$("#gzdw").val(arrselections[0].XGZDW);
	    			 $.ajaxSettings.async = false;
    	          	hyyijidm();
 	    	       $('#yijizy').selectpicker('val',(arrselections[0].HYYIJIDM));
    	          	yijizyb()
	    	       $.ajaxSettings.async = true;
  	    	       $('#erjizy').selectpicker('val',(arrselections[0].HYERJIDM));
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
    	                     url:"/sxunivw/Xyxxbgl",
    	                     data: {                     	
    	                     	"xyid":arrselections[0].ID,
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
    	        
    	        $("#defaultForm1").submit(function(ev){ev.preventDefault();});
    	        $("#btn_submit1").click(function () {
    	        var bootstrapValidator = $("#defaultForm1").data('bootstrapValidator');
         	        bootstrapValidator.validate();
         	        if(bootstrapValidator.isValid()){
         	        	var id = $("#btn_submit1").val();
         	        	var xyid = $("#id").val();
         	        	var xyxm = $("#xyxm").val();
        	            var xb = $("#xb").val();
        	            var rxnf = $("#rxnf").val();
        	            var gzdw = $("#gzdw").val();
        	            var yijizy=$("#yijizy").val();
        	            var erjizy=$("#erjizy").val();
        	            var ZYDM=$("#txt_zyxm").val();
        	            var XZYDM=$("#txt_zymc").val();
        	            var XYDM=$("#txt_xyxm").val();
        	            var XXDM=$("#txt_xxxm").val();
        	            if (erjizy == null || erjizy == undefined || erjizy == '') {
        	                toastr.warning('从事行业不能为空');
        	                $('#defaultForm1').data('bootstrapValidator').resetForm(true);
        	             }else{
        	            
        	            $.ajax({
        	                type: "post",
        	                url: "/sxunivw/Xyxxbgl",
        	                data: { 
        	                	"xyid":xyid,
        	                	"xyxm":xyxm,
        	                	"xb":xb,
        	                	"rxnf":rxnf,
        	                	"gzdw":gzdw,
        	                	"yijizy":yijizy,
        	                	"erjizy":erjizy,
        	                	"ZYDM":ZYDM,
        	                	"XZYDM":XZYDM,
        	                	"XYDM":XYDM,
        	                	"XXDM":XXDM,
        	                	"id":id,
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
         	        }}
	
    	        });
    	        
    	        $("#myModal1").on("hide.bs.modal", function () {
    	          	document.getElementById("defaultForm1").reset();
    	          	$("#defaultForm1").data('bootstrapValidator').resetForm();
    	          	});
    	        
    	  	  
    	  	  $('.form_datetime').datetimepicker({
    	  		  format: 'yyyy',
    	  	      autoclose: true,
    	  	      startView: 4,
    	  	      minView: 4,
    	  	      language: 'zh-CN'
    	  		}).on('changeDate',function(e) {
    	              $('#defaultForm1').data('bootstrapValidator')  
    	              .updateStatus('rxnf', 'NOT_VALIDATED',null)  
    	              .validateField('rxnf');  
    	      }).on('hide', function(event) {
    	  		event.preventDefault();
    	  		event.stopPropagation();
    	  		});
    	  	  
    	  	 var aDate = new Date(); 
    		  var EndDate=aDate.getFullYear()-7;
    		  $('#pytime').datetimepicker('setEndDate', EndDate);
    		  $('#rxnf').datetimepicker('setStartDate', '1949');
    	    
    	        var oTable = new TableInit();
    	        oTable.Init();

});
      function fresh(){
    	  $("#tb_departments").bootstrapTable('refresh');
      };
      
      
      var TableInit = function () {
    	    var oTableInit = new Object();
    	    //初始化Table
    	    oTableInit.Init = function () {
    	        $('#tb_departments').bootstrapTable({
    	            url: '/sxunivw/Xyxxbgl',         //请求后台的URL（*）
    	            method: 'post',                      //请求方式（*）
    	            toolbar: '#toolbar',                //工具按钮用哪个容器
    	            contentType : "application/x-www-form-urlencoded",
    	            striped: true,                      //是否显示行间隔色
    	            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
    	            pagination: true,                   //是否显示分页（*）
    	            sortable: false,                     //是否启用排序
    	            sortOrder: "asc",                   //排序方式
    	            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
    	            queryParams :function (params) {
    	                return {
    	                	ZYDM: $("#txt_zyxm").val(),
    	                	XZYDM: $("#txt_zymc").val(),
    	                	XYDM: $("#txt_xyxm").val(),
    	                	XXDM: $("#txt_xxxm").val()
    	                }
    	            },
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
    	            onLoadSuccess: function(data){  //加载成功时执行
    	            	$("*[name='JCXYRS']").val(data[0].SIZE); 
    	  	            },
    	            columns: [{
    	                  checkbox: true
    	              },  {
    	                  field: 'XM',
    	                  title: '校友姓名'
    	              }, {
    	                  field: 'XBG',
    	                  title: '性别'
    	              } ,
    	              {
    	                  field: 'RXNF',
    	                  title: '入学年份'
    	              } ,
    	              {
    	                  field: 'XGZDW',
    	                  title: '工作单位'
    	              } , {
    	                  field: 'CSHY',
    	                  title: '从事行业'
    	              } ,],
    	        });
    	    };
    	    return oTableInit;
    	};

    	function yijizyb(){  
    	    var zydm=$("#yijizy").val();
    	        	$("#erjizy").empty();
    	        	$("#erjizy").append($("<option >" +' - 请选择 - '+ "</option>"));
    	        	$.ajax({
    	    	    	type: "post", 
    	    	            url: "/sxunivw/Hydmxl",
    						data:{
    	    	            	"zydm":zydm,
    	    	            	"id":2
    	    	            },
    	    	    	success: function (data) {
    	    		        for (var i = 0; i < data.length; i++) {
    	    		            $('#erjizy').append("<option value=" + data[i].HYERJIDM + ">" + data[i].HYERJIDMMC +"</option>");
    	    		        }
    	    		        $('#erjizy').selectpicker('refresh');
    	    		        $('#erjizy').selectpicker('render');
    	    	    }
    	    	});
    	    } ;
function hyyijidm(){
	$("#yijizy").empty();
	$("#yijizy").append($("<option >" +' - 请选择 - '+ "</option>"));
  	  $.ajax({
	    	type: "post",  
	  	      url: "/sxunivw/Hydmxl",
	          data: {                     	
	           	"id":1
	           },
	    	success: function (data) {
		        for (var i = 0; i < data.length; i++) {
		            $('#yijizy').append("<option value=" + data[i].HYYIJIDM + ">" + data[i].HYYIJIDMMC + "</option>");
		        }
		        $('#yijizy').selectpicker('refresh');
		        $('#erjizy').selectpicker('render');

	    }
	});
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
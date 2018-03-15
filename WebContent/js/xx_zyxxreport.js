      $(function () {
    	  
    	  toastr.options = {  
    		        closeButton: false,  
    		        debug: false,  
    		        progressBar: true,  
    		        positionClass: "toast-top-full-width",  
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
    	   
    	        var oTable = new TableInit();
    	        oTable.Init();

});
      
      var TableInit = function () {
    	    var oTableInit = new Object();
    	    //初始化Table
    	    oTableInit.Init = function () {
    	        $('#tb_departments').bootstrapTable({
    	            url: "/sxunivw/xx_zyxxreport",         //请求后台的URL（*）
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
    	            onLoadSuccess: function(data){  //加载成功时执行
    	  	            var x=document.getElementsByTagName("p");
    	  	          x[0].innerHTML="本科专业未填报专业:"+data[0].xxdm+"个,专科专业未填报专业:"+data[0].xydm+"个,以下为未填报专业。";
    	  	            },
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


        $('#report').click(function() {
        	  Ewin.confirm({ message: " 是否将所有数据上报服务器？" }).on(function (e) {
	                 if (!e) {
	                     return;
	            }
        	  var l = Ladda.create( document.querySelector( '#report' ) );
        	l.start();
        	 var progress = 0;
        	 progress = Math.random() * 7000+5000;
        	 setTimeout(func,progress);
        	 function func()
        	 {
        		l.stop();
        		toastr.success("数据上报完成");
        	 }
        	  });
          });

        
        
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
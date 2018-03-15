/*!

 =========================================================
 * Paper Bootstrap Wizard - v1.0.2
 =========================================================
 
 * Product Page: https://www.creative-tim.com/product/paper-bootstrap-wizard
 * Copyright 2017 Creative Tim (#)
 * Licensed under MIT (https://github.com/creativetimofficial/paper-bootstrap-wizard/blob/master/LICENSE.md)
 
 =========================================================
 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 */

// Paper Bootstrap Wizard Functions

searchVisible = 0;
transparent = true;

        $(document).ready(function(){
        	
        	 zylb();
        	
        	jQuery.extend(jQuery.validator.messages, {  
        		 required: "必选字段",  
        		 remote: "请修正该字段",  
        		 email: "请输入正确格式的电子邮件",  
        		 url: "请输入合法的网址",  
        		 date: "请输入合法的日期",  
        		 dateISO: "请输入合法的日期 (ISO).",  
        		 number: "请输入合法的数字",  
        		 digits: "只能输入整数",  
        		 creditcard: "请输入合法的信用卡号",  
        		 equalTo: "请再次输入相同的值",  
        		 accept: "请输入拥有合法后缀名的字符串",  
        		 maxlength: jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),  
        		 minlength: jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),  
        		 rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),  
        		 range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),  
        		 max: jQuery.validator.format("请输入一个最大为{0} 的值"),  
        		 min: jQuery.validator.format("请输入一个最小为{0} 的值")  
        		});

            /*  Activate the tooltips      */
            $('[rel="tooltip"]').tooltip();

            // Code for the Validator
            var $validator = $('.wizard-card form').validate({
        		  rules: {
        			  inputEmail: {
        		      required: true,
        		      minlength: 3
        		    },
        		    rules: {
        		      required: true,
        		      minlength: 1
        		    },
        		    email: {
        		      required: true
        		    }
                },
        	});

            // Wizard Initialization
          	$('.wizard-card').bootstrapWizard({
                'tabClass': 'nav nav-pills',
                'nextSelector': '.btn-next',
                'previousSelector': '.btn-previous',

                onNext: function(tab, navigation, index) {
                	var $valid = $('.wizard-card form').valid();
                	if(!$valid) {
                		$validator.focusInvalid();
                		return false;
                	}
                },

                onInit : function(tab, navigation, index){

                  //check number of tabs and fill the entire row
                  var $total = navigation.find('li').length;
                  $width = 100/$total;

                  navigation.find('li').css('width',$width + '%');

                },

                onTabClick : function(tab, navigation, index){

                    var $valid = $('.wizard-card form').valid();

                    if(!$valid){
                        return false;
                    } else{
                        return true;
                    }

                },

                onTabShow: function(tab, navigation, index) {
                    var $total = navigation.find('li').length;
                    var $current = index+1;

                    var $wizard = navigation.closest('.wizard-card');

                    // If it's the last tab then hide the last button and show the finish instead
                    if($current >= $total) {
                        $($wizard).find('.btn-next').hide();
                    } else {
                        $($wizard).find('.btn-next').show();
                    }

                    //update progress
                    var move_distance = 100 / $total;
                    move_distance = move_distance * (index) + move_distance / 2;

                    $wizard.find($('.progress-bar')).css({width: move_distance + '%'});
                    //e.relatedTarget // previous tab

                    $wizard.find($('.wizard-card .nav-pills li.active a .icon-circle')).addClass('checked');

                }
	        });


                // Prepare the preview for profile picture
                $("#wizard-picture").change(function(){
                    readURL(this);
                });

                $('[data-toggle="wizard-radio"]').click(function(){
                    wizard = $(this).closest('.wizard-card');
                    wizard.find('[data-toggle="wizard-radio"]').removeClass('active');
                    $(this).addClass('active');
                    $(wizard).find('[type="radio"]').removeAttr('checked');
                    $(this).find('[type="radio"]').attr('checked','true');
                });

                $('[data-toggle="wizard-checkbox"]').click(function(){
                    if( $(this).hasClass('active')){
                        $(this).removeClass('active');
                        $(this).find('[type="checkbox"]').removeAttr('checked');
                    } else {
                        $(this).addClass('active');
                        $(this).find('[type="checkbox"]').attr('checked','true');
                    }
                });

                $('.set-full-height').css('height', 'auto');
                
                $('#finish').click(function() {
               	 var zydm = $("#zydm").val();
            	 Ewin.confirm({ message: "确认要删除数据吗？" }).on(function (e) {
  	                 if (!e) {
  	                     return;
  	                 }
  	                 $.ajax({
  	                     type: "post",
  	                     url:"/sxunivw/XY_ZKZyxxdelete",
  	                     data: {                     	
  	                     	"zydm":zydm
  	                     },
  	                     success: function (data, status) {
  	                         if (status == "success") {
  	                        	toastr.success('数据删除成功');
  	                      	   setTimeout("location.reload(true) ",1000);
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

            });

        function zylb() {  
    	        	$("#txt_zyxm").append($("<option >" +' - 请选择 - '+ "</option>"));
    	        	$.ajax({
    	    	    	type: "post",  
    	    	            url: "/sxunivw/Xyzyfiad",
    						data:{
    	    	            	"zylb":2
    	    	            },
    	    	    	success: function (data) {
    	    	    		 $("#txt_zyxm").empty();
    	    	    		    $("#txt_zyxm").append($("<option >" +' - 请选择 - '+ "</option>"));
    	    	    		    for (var i = 0; i < data.length; i++) {  
    	    	    		        //传递参数       
    	    	    		        $("#txt_zyxm").append($("<option value='" + data[i].zyidxlsh + "'>" + data[i].yijizy + '——' + data[i].erjizy + '——' + data[i].sanjizy + "</option>"));  
    	    	    		    } 
    	    	    }
    	    	});
    	    } 
        
        function find() {  
        	$("input[type=reset]").trigger("click");

        	 var zydm=$("#txt_zyxm").val();
     	    var zymc= $("#txt_zyxm").find("option:selected").text();
     	    $("#zymc").val(zymc);
     	    $("#zydm").val(zydm);
    	    $.ajax({
                type: "post",
                url: "/sxunivw/XY_ZKZyxxrevise",
                dataType: "json",
				data:{
						"zydm":zydm,
    	    	      },
                success: function (data, status) {
                	//ZKTBCXCY1
                    if (status!=0) {
                    	//ZKTBCXCY1
                    	$("*[name='CYKCBZ']").val(data[0].CYKCBZ);
                    	$("*[name='CYZDJSRS']").val(data[0].CYZDJSRS); 
                    	$("*[name='GZRS']").val(data[0].GZRS); 
                    	$("*[name='TXSZBZ']").val(data[0].TXSZBZ); 
                    	
                    	//ZKTBJIAOSHI1
                    	$("*[name='BSJSZS']").val(data[1].BSJSZS);
                    	$("*[name='FGJSZS']").val(data[1].FGJSZS); 
                    	$("*[name='JSZS']").val(data[1].JSZS); 
                    	$("*[name='MEDIANJSZS']").val(data[1].MEDIANJSZS); 
                    	$("*[name='SYJSZS']").val(data[1].SYJSZS);
                    	$("*[name='WPJSZS']").val(data[1].WPJSZS); 
                    	$("*[name='YOUNGJSZS']").val(data[1].YOUNGJSZS); 
                    	$("*[name='ZGJSZS']").val(data[1].ZGJSZS); 
                    	
                    	//ZKTBJIUYE
                    	$("*[name='BYSCCJYL']").val(data[2].BYSCCJYL); 
                    	$("*[name='BYSMYD']").val(data[2].BYSMYD); 
                    	$("*[name='ZZCYRS']").val(data[2].ZZCYRS); 
                    	
                    	//ZKTBJSSZSP
                    	$("*[name='DNCGFXS']").val(data[3].DNCGFXS);
                    	$("*[name='DNCSCD']").val(data[3].DNCSCD); 
                    	$("*[name='DNCSSCI']").val(data[3].DNCSSCI); 
                    	$("*[name='DNEI']").val(data[3].DNEI); 
                    	$("*[name='DNGJJXJS']").val(data[3].DNGJJXJS);
                    	$("*[name='DNGJJXMS']").val(data[3].DNGJJXMS);
                    	$("*[name='DNGJKJJS']").val(data[3].DNGJKJJS); 
                    	$("*[name='DNHXDK']").val(data[3].DNHXDK); 
                    	$("*[name='DNISTP']").val(data[3].DNISTP); 
                    	$("*[name='DNSCI']").val(data[3].DNSCI);
                    	$("*[name='DNSJJXJS']").val(data[3].DNSJJXJS);
                    	$("*[name='DNSJKJJS']").val(data[3].DNSJKJJS); 
                    	$("*[name='DNSKZGJSS']").val(data[3].DNSKZGJSS); 
                    	$("*[name='DNSSCI']").val(data[3].DNSSCI); 
                    	$("*[name='DNZXDK']").val(data[3].DNZXDK);
                    	$("*[name='GJJJXTDS']").val(data[3].GJJJXTDS);
                    	$("*[name='GJJKYTDS']").val(data[3].GJJKYTDS); 
                    	$("*[name='GSPJSS']").val(data[3].GSPJSS); 
                    	$("*[name='SJJXTDS']").val(data[3].SJJXTDS); 
                    	$("*[name='SJKYTDS']").val(data[3].SJKYTDS);
                    	$("*[name='DNSBXMS']").val(data[3].DNSBXMS);
                    	$("*[name='DNZLS']").val(data[3].DNZLS); 
                    	$("*[name='DNRJZZQS']").val(data[3].DNRJZZQS); 
                    
                    	//ZKTBJXGG1
                    	$("*[name='DNGJJJCS']").val(data[4].DNGJJJCS); 
                    	$("*[name='DNGJJJPKCS']").val(data[4].DNGJJJPKCS);
                    	$("*[name='DNGJJJXCGJ']").val(data[4].DNGJJJXCGJ);
                    	$("*[name='DNJGLWS']").val(data[4].DNJGLWS); 
                    	$("*[name='DNQTJCS']").val(data[4].DNQTJCS); 
                    	$("*[name='DNSJJJXCGJ']").val(data[4].DNSJJJXCGJ); 
                    	$("*[name='DNSJJPKCS']").val(data[4].DNSJJPKCS);
                    	$("*[name='DNSJJXCGJS']").val(data[4].DNSJJXCGJS);
                    	$("*[name='DNSJJXYJS']").val(data[4].DNSJJXYJS); 
                    	$("*[name='DNSJYXJCS']").val(data[4].DNSJYXJCS); 
                    	$("*[name='SJRCPYSYCS']").val(data[4].SJRCPYSYCS); 
                    	$("*[name='GJJJXZYKBZ']").val(data[4].GJJJXZYKBZ); 
                    	$("*[name='SJJXZYKBZ']").val(data[4].SJJXZYKBZ); 
                    	
                    	//ZKTBJXTJ1
                    	$("*[name='DNJXJF']").val(data[5].DNJXJF); 
                    	$("*[name='DNRJF']").val(data[5].DNRJF); 
                    	$("*[name='DNSBF']").val(data[5].DNSBF); 
                    	$("*[name='ZRJF']").val(data[5].ZRJF); 
                    	$("*[name='ZSBF']").val(data[5].ZSBF); 
                    	$("*[name='ZYTUSHU']").val(data[5].ZYTUSHU); 
                    	
                    	//ZKTBJYJBXX1
                    	$("*[name='CXFAXMS']").val(data[6].CXFAXMS);
                    	$("*[name='GCRZBZ']").val(data[6].GCRZBZ);
                    	$("*[name='SJZHGGBZ']").val(data[6].SJZHGGBZ);
                    	$("*[name='SXYLZYBZ']").val(data[6].SXYLZYBZ);
                    	$("*[name='ZYBXRQ']").val(data[6].ZYBXRQ);
                    	$("*[name='YSZYLX']").val(data[6].YSZYLX);
                    	$("*[name='XWSYQ']").val(data[6].XWSYQ);
                    	
                    	//ZKTBPYFA1
                    	$("*[name='BYXFZS']").val(data[7].BYXFZS);
                    	$("*[name='LLXFZS']").val(data[7].LLXFZS);
                    	$("*[name='XXKXFZS']").val(data[7].XXKXFZS);
                    	$("*[name='SJKXFZS']").val(data[7].SJKXFZS);
                    	$("*[name='CXXFZS']").val(data[7].CXXFZS);
                    	$("*[name='PYFAURL']").val(data[7].PYFAURL);
                    	$("*[name='PYFAXDNF']").val(data[7].PYFAXDNF);
                    	
                    	//ZKTBPYXG1
                    	$("*[name='GJJNJSCJRS']").val(data[8].GJJNJSCJRS);
                    	$("*[name='SXJNJSCJRS']").val(data[8].SXJNJSCJRS);
                    	$("*[name='GJJNJSDJS']").val(data[8].GJJNJSDJS);
                    	$("*[name='SXXKJSDJS']").val(data[8].SXXKJSDJS);
                    	$("*[name='SNGJHLWDJS']").val(data[8].SNGJHLWDJS);
                    	$("*[name='SNSXHLWDJS']").val(data[8].SNSXHLWDJS);
                    	$("*[name='GJDCS']").val(data[8].GJDCS);
                    	$("*[name='SJDCS']").val(data[8].SJDCS);
                    	$("*[name='LWS']").val(data[8].LWS);
                    	$("*[name='YINGYUA']").val(data[8].YINGYUA);
                    	$("*[name='YINGYUB']").val(data[8].YINGYUB);
                    	$("*[name='SJJLS']").val(data[8].SJJLS);
                    	$("*[name='JXJS']").val(data[8].JXJS);
                    	$("*[name='ZLS']").val(data[8].ZLS);
                    	$("*[name='ZYZSHQL']").val(data[8].ZYZSHQL);
                    	$("*[name='XJXSGBRS']").val(data[8].XJXSGBRS);
                    	$("*[name='SJXKJSCJRS']").val(data[8].SJXKJSCJRS);
                    	$("*[name='SJXKJSHJRS']").val(data[8].SJXKJSHJRS);
                    	$("*[name='WTJSHJRS']").val(data[8].WTJSHJRS);
                    	$("*[name='GJHYRS']").val(data[8].GJHYRS);
                    	$("*[name='XSRDJJFZ']").val(data[8].XSRDJJFZ);
                    	$("*[name='XSYBDYS']").val(data[8].XSYBDYS);
                    	$("*[name='XSZSDYS']").val(data[8].XSZSDYS);
                    	$("*[name='XSCJGYHDRS']").val(data[8].XSCJGYHDRS);
                    	$("*[name='JCXYRS']").val(data[8].JCXYRS);
                    	
                    	//ZKTBSJJX1
                    	$("*[name='BYLWBL']").val(data[9].BYLWBL);
                    	$("*[name='DNDDBXSS']").val(data[9].DNDDBXSS);
                    	$("*[name='GJJSYSS']").val(data[9].GJJSYSS);
                     	$("*[name='GJJXNZSS']").val(data[9].GJJXNZSS);
                    	$("*[name='SJJXJF']").val(data[9].SJJXJF);
                    	$("*[name='DNXDXTS']").val(data[9].DNXDXTS);
                     	$("*[name='SJSYSS']").val(data[9].SJSYSS);
                    	$("*[name='SJXNZSS']").val(data[9].SJXNZSS);
                    	$("*[name='XNSXJD']").val(data[9].XNSXJD);
                     	$("*[name='XQLHPYXYS']").val(data[9].XQLHPYXYS);
                    	$("*[name='XWSXJD']").val(data[9].XWSXJD);
                    	$("*[name='GJJSCSXJDS']").val(data[9].GJJSCSXJDS);
                    	$("*[name='SJSCSXJDS']").val(data[9].SJSCSXJDS);
                    	
                    	//ZKTBSYB1
                    	$("*[name='JHZSRS']").val(data[10].JHZSRS);
                    	$("*[name='SJZSRS']").val(data[10].SJZSRS);
                    	$("*[name='ZSPJF']").val(data[10].ZSPJF);
                     	$("*[name='ZSPJWC']").val(data[10].ZSPJWC);
                    	$("*[name='ZSZDF']").val(data[10].ZSZDF);
                    	$("*[name='ZSZDWC']").val(data[10].ZSZDWC);
                    	$("*[name='ZSZGF']").val(data[10].ZSZGF);
                    	$("*[name='ZSZGWC']").val(data[10].ZSZGWC);
                     	$("*[name='ZSZSRS']").val(data[10].ZSZSRS);
                    	$("*[name='ZXSRS']").val(data[10].ZXSRS);
                    	$("*[name='JNZRS']").val(data[10].JNZRS);
                    	$("*[name='GATZRS']").val(data[10].GATZRS);
                     	$("*[name='LXSZRS']").val(data[10].LXSZRS);
                    	$("*[name='SJLQS']").val(data[10].SJLQS);
                    	$("*[name='ZZZSRS']").val(data[10].ZZZSRS);
                    	$("*[name='ZTCSRS']").val(data[10].ZTCSRS);
                    	
                    	//ZKTBZYXYL1
                    	$("*[name='JSLXSRS']").val(data[11].JSLXSRS);
                    	$("*[name='SCLXSRS']").val(data[11].SCLXSRS);
                    	$("*[name='YJSLQRS']").val(data[11].YJSLQRS);
                     	$("*[name='ZCRS']").val(data[11].ZCRS);
                    	$("*[name='ZRRS']").val(data[11].ZRRS);
                    	
                    	//ZKTBZLBZ1
                    	$("*[name='JXDDBZ']").val(data[12].JXDDBZ);
                     	$("*[name='JXJDPJ']").val(data[12].JXJDPJ);
                    	$("*[name='ZLBZBZ']").val(data[12].ZLBZBZ);
                    	
                    	toastr.success("表单载入成功");
                   }else{
                    	toastr.success("表单载入失败");
                    }   

                },
                error: function () {
                	toastr.error('服务器无返回');
                	
                },
                complete: function () {

                }

            });
    	    } 

         //Function to show image before upload

        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
                }
                reader.readAsDataURL(input.files[0]);
            }
        };
        $.fn.serializeObject = function()    
        {    
           var o = {};    
           var a = this.serializeArray();    
           $.each(a, function() {    
               if (o[this.name]) {    
                   if (!o[this.name].push) {    
                       o[this.name] = [o[this.name]];    
                   }    
                   o[this.name].push(this.value || '');    
               } else {    
                   o[this.name] = this.value || '';    
               }    
           });    
           return o;    
        };  
        
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



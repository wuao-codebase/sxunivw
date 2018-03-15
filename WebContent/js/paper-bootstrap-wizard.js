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
                        $($wizard).find('.btn-finish').show();
                    } else {
                        $($wizard).find('.btn-next').show();
                        $($wizard).find('.btn-finish').hide();
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
                	var l = Ladda.create( document.querySelector( '#finish' ) );
                	var $valid = $('.wizard-card form').valid();
                	var jsonuserinfo = $('#forms').serializeArray();

                    if(!$valid){
                    	toastr.error('有选项未填');
                    	return false;
                    } else{
                    	
                    	var sta = $("#file-1").text();
                    	
                    	if (sta==1){
                    		l.start();
//                    		setTimeout("",5000);
                        	$.ajax({
                                type: "post",
                                url: "/sxunivw/UpLoad",
                                data:{ds:JSON.stringify(jsonuserinfo)},
                                dataType: "json",
                                success: function (data, status) {
                                    if (status!=0) {
                                    	toastr.success("表单提交成功");
                                    }else{
                                    	toastr.success("表单提交失败");
                                    }     

                                },
                                error: function () {
                                	toastr.error('服务器无返回');
                                	
                                },
                                complete: function () {
                                	l.stop();
                                }

                            });
                    	
                    	}else{toastr.error('培养方案未上传')}
                    	return true;
                    }

                   
        		});	

            });



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
        
        

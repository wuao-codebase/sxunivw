<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>系统提示</title>
<%@ include file="navigation.jsp" %>
	 <link href="css/paper-bootstrap-wizard.css" rel="stylesheet" />
	 <link rel="stylesheet" href="css/toastr.min.css">
	  <link rel="stylesheet" href="css/ladda-themeless.min.css">
  </head>
  <body>
 	
 	<div class="image-container set-full-height" style="	background-attachment: fixed;background-color: rgba(0, 0, 0, 0);background-image: url(img/bg21.png);background-position: 50% 0%;background-position-x: 50%;background-position-y: 0%;background-repeat: repeat;background-size: auto auto;">


	    <!--   Big container   -->
	    <div class="container">
	        <div class="row">
		        <div class="col-lg-10 col-lg-offset-1">

		            <!--      Wizard container        -->
		            <div class="wizard-container">
		                <div class="card wizard-card" data-color="blue" id="wizard">
		                <form action="" method="" class="form-horizontal" id="forms">
		                <!--        You can switch " data-color="green" "  with one of the next bright colors: "bue", "azure", "orange", "red"       -->

		                    	<div class="wizard-header">
		                        	<h3 class="wizard-title" style="color:#F00;font-size:30px;">系统提示</h3>
		                    	</div>
								
							
		                        <div class="tab-content" style="text-align:left;font-size:25px;">
		                        
		                          
		                         <h>&nbsp;&nbsp;  &nbsp;&nbsp;  &nbsp;&nbsp;陕西省专业普查大数据报送系统正在初始化中，请各高校按照要求认真准备数据，近日将开通报送功能。</h>
      								<br/>
      								<br/>
      								<br/>
                                 <a style="float:right;" href="Ziliaodownload?id=1">本科专业报送格式下载</a><br> 
                                 <a style="float:right;" href="Ziliaodownload?id=2">专科专业报送格式下载</a> 


		                         
		                      
		                        
		                          
		                        
		                        </div>
		                        
		                        <div class="wizard-footer">
	                            	<div class="pull-right">
<!-- 	                            	<button id="report" type='button' name="report" class="btn btn-finish btn-fill btn-warning ladda-button btn-wd" data-style="contract"><span class="ladda-label">数据上报</span></button> -->
									
									</div>

	                                <div class="pull-left">
	                                </div>
	                                <div class="clearfix"></div>
		                        </div>
		                        
		                    </form>
		                </div>
		            </div> <!-- wizard container -->
		        </div>
	        </div> <!-- row -->
	    </div> <!--  big container -->

                     
	</div>
	<script src="js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
    <script src="js/toastr.min.js"></script>
    <script src="js/spin.min.js"></script>
	<script src="js/ladda.min.js"></script> 
	<script type="text/javascript">
	// Bind normal buttons
    $('#report').click(function() {
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
</script>

  </body>
</html>
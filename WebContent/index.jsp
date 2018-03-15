<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" href="css/style.css">
	<link href="css/verificationNumberStyle.css" rel="stylesheet"  />
	<link rel="stylesheet" href="css/toastr.min.css">
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
	<style type="text/css">
    	@font-face {
	font-family: 'Open Sans';
	src: url('fonts/icomoon.eot');
	src: url('fonts/icomoon.eot?#iefix') format('embedded-opentype'),
		url('fonts/icomoon.woff') format('woff'),
		url('fonts/icomoon.ttf') format('truetype'),
		url('fonts/icomoon.svg#open_sansregular') format('svg');
	font-weight: normal;
	font-style: normal;
	}
	body{   
		font-family:"Open Sans";
	 -webkit-font-smoothing: antialiased;
		}

	</style>
</head>
<body>
	
		<div class="cont_principal">		
		  <div class="cont_join ">
		    <div class="cont_letras">
		    <br>
		    <br>
		    <br>
		    
<!-- 		      <p>欢迎使用本系统(*^_^*)</p> -->
		   
		      
		    </div>

		    <div class="cont_form_join">
		      <p>用户名:</p>    
		      <input id="un" type="text" class="input_text" />

		      <p>密　码:</p>    
		      <input id="pw" type="password" class="input_text" />
		      <p>请输入验证码:</p> 
		<div class="val_icon" >
			
			<input type="text" id="J_codetext" placeholder="" maxlength="4" class="login_txtbx">
				<canvas class="J_codeimg" id="myCanvas" onclick="createCode()"></canvas>
<!-- 			<input type="button" value="验证码核验" class="ver_btn" onClick="validate();"> -->
		</div>
		    </div>
		  
		    <div class="cont_btn_join">
		      <button id="submit" type="submit" onclick='join_1()' >登 录</button>
		    </div>
		  </div>
		  <p style=" position:absolute; bottom:0px; padding-left:30px;padding-bottom:30px;font-size: 38px; z-index:1;">陕西省普通高校专业普查大数据报送系统</p>
		</div>
		
			<div id="footer" class="footer" >
                                     
                    <div class="ft-info"><a href="">联系我们</a> ┊ <a href="help.jsp">使用帮助</a>  ┊ <a href="softdown.jsp">软件下载</a> ┊ <a href="">©陕西省教育厅</a></div>                 
                   
<!--                     <p>&nbsp;</p> -->
 </div>
	<script src="js/jquery.min.js"></script>
 <script src="js/toastr.min.js"></script>
 <script src="js/index.js"></script>
<script type="text/javascript">
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
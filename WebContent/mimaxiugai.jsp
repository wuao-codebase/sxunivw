<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>操作员口令修改</title>
    <link rel="stylesheet" href="css/toastr.min.css">
	<link href="css/form.css" rel="stylesheet">
    
  </head>
  <body>
 	<%@ include file="navigation.jsp" %>
 	
<div id="container" class="container col-sm-6 col-sm-offset-3">
<form class="form-horizontal" id="defaultForm">
  <fieldset>
			<legend>操作员口令修改</legend>
                
     <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">用户口令:</label>
      <div class="col-lg-10">
        <input class="form-control"  name="username" type="text" placeholder="${user.czyzgh}" disabled>
      </div>
    </div>
    <div class="form-group">
      <label  class="col-lg-2 control-label">新密码:</label>
      <div class="col-lg-10">
        <input class="form-control" name="password" digits="1" maxlength="8" 	rangelength="8,8"    id="password" type="password"  required>
      </div>
    </div>
    <div class="form-group">
      <label  class="col-lg-2 control-label">重复新密码:</label>
      <div class="col-lg-10">
        <input class="form-control"  name="repassword" digits="1" maxlength="8"  id="repassword" rangelength="8,8" type="password" equalTo="#password" required>
      </div>
    </div>
				        
       <div class="form-group">
                <div class="col-lg-9 col-lg-offset-3">
                    <button type="submit" value="submit" class="submit btn btn-info" id="btn_submit">确认</button>
                </div>
            </div>    
      
  
  </fieldset>
</form>
</div>
	<script src="js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="js/toastr.min.js"></script>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		
            $("#defaultForm").validate();
      
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
        	
	});
	$.validator.setDefaults({
	    submitHandler: function() {
	    	 var password = $("#password").val();
        	 $.ajax({
                 type: "post",
                 url: "/sxunivw/Mimaxiugai",
                 data:{password:password},
                 success: function (data, status) {
                     if (status!=0) {
                     	toastr.success("密码修改成功");
                     }else{
                     	toastr.success("密码修改失败");
                     }     

                 },
                 error: function () {
                 	toastr.error('服务器无返回');
                 	
                 },
                 complete: function () {

                 }

             });
	    }
	});
	</script>
  </body>
</html>
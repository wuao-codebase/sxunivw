/*
---------------------------
-Click on the Button Join !-
---------------------------
*/

$(function(){
$("#submit").click();
});
 
var t = 0;

function join_1(){
if(t == 0){  
	createCode();
//	document.querySelectorAll('.cont_letras > p')[0].style.left = '300px';
 
setTimeout(function(){
  document.querySelector('.cont_join').className = 'cont_join cont_join_form_act';
},300);    
t++;
          }
else{
lod();
}       
}  

function showCheck(a){
	var c = document.getElementById("myCanvas");
  var ctx = c.getContext("2d");
	ctx.clearRect(0,0,1000,1000);
	ctx.font = "80px 'Microsoft Yahei'";
	ctx.fillStyle = "white";
	ctx.fillText(a,0,100);
	//
}
var code ;
function createCode(){
    code = "";
    var codeLength = 4;
    var selectChar = new Array(1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
    for(var i=0;i<codeLength;i++) {
       var charIndex = Math.floor(Math.random()*60);
      code +=selectChar[charIndex];
    }
    if(code.length != codeLength){
      createCode();
    }
    showCheck(code);
}
var sub = false;
function validate () {
    var inputCode = document.getElementById("J_codetext").value.toUpperCase();
    var codeToUp=code.toUpperCase();
    if(inputCode.length <=0) {
    	toastr.error('请输入验证码!')
      createCode();
      return false;
    }
    else if(inputCode != codeToUp ){
      document.getElementById("J_codetext").value="";
      toastr.error('验证码错误!')
      createCode();
      return false;
    }
    else {
      // window.open(document.getElementById("J_down").getAttribute("data-link"));
      // document.getElementById("J_codetext").value="";
      // createCode();
      sub = true;
      return true;
    }
}

function lod () {
	var userName = $("#un").val();
	var password = $("#pw").val();
	var obint = /^(\d+)$/;
	if (userName == "" || userName == null){
		toastr.error("用户名不能为空!");
        return false ;
    }
	else if(userName.length<10|| userName.length>10){
    		toastr.error("用户名为10位数字!");
            return false ;
        }else if(obint.test(userName)==false){
    		toastr.error("用户名为10位数字!");
            return false ;
        }
	

    if (password == "" || password == null){
    	toastr.error("密码不能为空!");
        return false ;
    }else if(password.length<8|| password.length>8){
		toastr.error("密码为8位数字!");
        return false ;
    }else if(obint.test(password)==false){
		toastr.error("密码为8位数字!");
        return false ;
    }else{validate ();}
	
	
			if (sub) { 
				
            $.ajax({
                type: "post",
                url: "/sxunivw/LoginCheck",
                data: { 
                	"userName":userName,
                	"password":password  
                	},
                success: function (data, status) {
                    if (status == "success") {
                    	toastr.success('登陆成功');
                    	if(data[0].czylb==1){
                    		if(data[0].zylb==1){
                    			window.location.href='daohangyebk.jsp';
                    		}
                    		if(data[0].zylb==2){
                    			window.location.href='daohangyezk.jsp';
                    		}
                    		
                    	}
                    	if(data[0].czylb==2){
                    		window.location.href='daohangye2.jsp';
                    	}
                    	if(data[0].czylb==3){
                    		window.location.href='daohangye3.jsp';
                    	}
                    	if(data[0].czylb==4){
                    		window.location.href='daohangye4.jsp';
                    	}
//                    	window.location.href='announcement.jsp';
                    }   

                },
                error: function () {
                    toastr.error('用户或密码错误');
                    createCode();
                },
                complete: function () {

                }

            });

//				window.location.href='level1.jsp';
			}else {
				 
			}

	
	
}
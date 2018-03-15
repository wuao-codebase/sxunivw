<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>顶部导航</title>

    <!-- Bootstrap -->
    <link href="bootstrap3/css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
  </head>
  <body>
    <div class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header" style="cursor:pointer;">
          <a onclick="history.go(-1)" class="navbar-brand" >主页</a>
           <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        
        <div class="navbar-collapse collapse" id="navbar-main">
          <ul class="nav navbar-nav">
          	<li>
              <a >${user.xxxm}</a>
            </li>

            <li>
              <a >${user.czyxm}</a>
            </li>
            
            <li>
              <a >${user.czyzgh}</a>
            </li>
            
            <li>
              <a >${user.czyzl}</a>
            </li>
            
             <li>
              <a >${user.xyxm}</a>
            </li>
           

          </ul>

          <ul class="nav navbar-nav navbar-right">
             <li><a href="LoginOut" >退出</a></li>
          </ul>
             
        </div>
      </div>
    </div>
    
    
  
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap3/js/bootstrap.min.js"></script>

  </body>
</html>
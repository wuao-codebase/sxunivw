<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>导航页</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <link rel="stylesheet" type="text/css" href="css/metro.css">
    	<script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/metro.js"></script>

        <!-- Computed in PHP based on your settings -->
        <style>
            #widget_scroll_container {
                width: 2160px;
            }
            div.widget_container {
                width: 1200px;
            }
            div.widget_container.half {
                width: 400px;
            }
            @media screen and (max-height: 680px) {
                #widget_scroll_container {
                    width: 1660px;
                }
                div.widget_container {
                    width: 900px;
                }
                div.widget_container.half {
                    width: 300px;
                }
            }
        </style>
    <body class="loaded"><header><h2>&nbsp;&nbsp;陕西省高等学校专业普查大数据系统</h2></header>
        <div id="widget_scroll_container" style="left: 59px;">
            <div class="widget_container half">
            <h4>本科专业</h4>
                  <div class="widget widget4x2 widget_blue" onclick="window.open('jyt-zyxxexport.jsp','_self')">
                    <div class="widget_content">
                        <div class="main" style="background-image:url(img/7.png);">
                            <span>本科专业数据查询</span>
                        </div>
                    </div>
                </div>
                <div class="widget widget4x2 widget_red widget_link" style="background-color:#3E3F3A;" onclick="window.open('Jyt_zkzyxxexport.jsp','_self')">
                    <div class="widget_content">
                        <div class="main" style="background-color:#3E3F3A;background-image:url(img/7.png);">
                            <span>专科专业数据查询</span>
                        </div>
                    </div>
                </div>      
            </div>

            <div class="widget_container half"  >
             <h4>专科专业</h4>
                <div class="widget widget4x2 widget_orange widget_link" onclick="window.open('jyt_czy_gl.jsp','_self')">
                    <div class="widget_content">
                        <div class="main" style="background-image:url(img/9.png);">
                            <span>操作员管理</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="widget_container half">
            <h4>其他功能</h4>
       			<div class="widget widget2x2 widget_green" onclick="window.open('mimaxiugai.jsp','_self')">
                    <div class="widget_content">
                        <div class="main" style="background-image:url(img/5.png);">
                            <span>口令修改</span>
                        </div>
                    </div>
                </div>
                <div class="widget widget2x2 widget_darkred" onclick="window.open('LoginOut','_self')">
                    <div class="widget_content">
                        <div class="main" style="background-image:url(img/10.png);">
                            <span>退出系统</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>学院管理</title>
    <link rel="stylesheet" href="css/toastr.min.css">
    <link rel="stylesheet" href="css/bootstrap-table.css">
    <link rel="stylesheet" href="css/bootstrapValidator.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css"/>
	<link href="css/form.css" rel="stylesheet">
    
  </head>
  <body>
 	<%@ include file="navigation.jsp" %>
 	
<div id="container" class="container col-sm-6 col-sm-offset-3">
<form class="form-horizontal">
  <fieldset>
  <legend>学校学院管理</legend>
			
                   <div class="btn-group " id="toolbar">
                        
				            <button id="btn_add" type="button" class="btn btn-primary">
				                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
				            </button>
				            
				            <button id="btn_edit" type="button" class="btn btn-warning">
				               <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>修改
				            </button>
				            <button id="btn_delete" type="button" class="btn btn-danger">
				                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				            </button>		
                   </div>
                      
       <table id="tb_departments" data-reorderable-columns="true"></table>
  
  </fieldset>
</form>
</div>

   <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;">
    <div class="modal-dialog" role="document">
      <form id="defaultForm" class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
          <h4 class="modal-title" id="myModalLabel">新增</h4>
        </div>
        <div class="modal-body">
 
          <div class="form-group">
           <label for="txt_departmentname">教学单位名称</label>
            <input  type="text" name="txt_jxdwmc" class="form-control" id="txt_jxdwmc">
          </div>
          
	   	<div class="form-group">				         	
           		 <label class=" control-label">成立年份</label>
       			 <div class="input-group">
	 		<input type="text" class="form-control form_datetime" id="txt_chenlinian" name="txt_chenlinian" value="" placeholder="" readonly>
	  		 <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
		 </div>											                     
              </div>
 
          <div class="form-group">
            <label for="txt_departmentlevel">联系人</label>
            <input type="text" name="txt_lxr" class="form-control" id="txt_lxr" placeholder="">
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">联系电话</label>
            <input type="text" name="txt_lxdh" class="form-control" id="txt_lxdh" placeholder="请准确输入电话号码，以方便联系填报人纠正填报数据的失误">
          </div>
                    <div class="form-group">
            <label for="txt_departmentlevel">学院代码</label>
            <input type="text" name="txt_xydm" class="form-control" id="txt_xydm" placeholder="系统自动生成"  disabled>
          </div>
        </div>
        
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
          <button  type="submit" id="btn_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
        </div>
      </form>
    </div>
  </div>
  
	<script src="js/bootstrap-datetimepicker.min.js"></script>
	<script src="js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="js/toastr.min.js"></script>
    <script src="js/bootstrap-table.js"></script>
    <script src="js/bootstrap-table-zh-CN.js"></script>
    <script src="js/bootstrap-table-export.js"></script>
    <script src="js/tableExport.js"></script>
    <script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
    <script type="text/javascript" src="js/xx_xyxx_gl.js"></script>
  </body>
</html>
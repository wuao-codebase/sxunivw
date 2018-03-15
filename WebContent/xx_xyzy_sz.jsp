<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>学校专业设置</title>
    <link rel="stylesheet" href="css/toastr.min.css">
    <link rel="stylesheet" href="css/bootstrap-table.css">
    <link rel="stylesheet" href="css/bootstrapValidator.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-select.css">
	<link href="css/form.css" rel="stylesheet">
    
  </head>
  <body>
 	<%@ include file="navigation.jsp" %>
 	
<div id="container" class="container col-sm-6 col-sm-offset-3">
<form class="form-horizontal">
  <fieldset>
			<legend>学校专业管理</legend>
                  <div class="btn-group " id="toolbar">
   
				            <button id="btn_add1" type="button" class="btn btn-primary">
				               <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
				            </button>
				            
				            <button id="btn_delete" type="button" class="btn btn-danger">
				                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				            </button>		
                   </div>
                      
       <table id="tb_departments" data-reorderable-columns="true"></table>
  
  </fieldset>
</form>
</div>

   <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;">
    <div class="modal-dialog" role="document">
      <form id="defaultForm1" class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
          <h4 class="modal-title" id="myModalLabel">添加专业</h4>
        </div>
        <div class="modal-body">
        <div class="form-group">
            <label for="txt_departmentlevel">单位名称</label>
            <input type="text" name="txt_xxxm" class="form-control" id="txt_xxxm" placeholder="${user.xxxm}" disabled>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">学院</label>
            <select id='txt_xyxm' class="form-control selectpicker"  data-live-search="true"></select>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">专业类别</label>
            <select id='txt_zylb'  OnChange="zylb()" class="form-control selectpicker"  data-live-search="true" >
            <option disabled="" selected="">- 请选择 -</option>
               <option value ="1">本科</option>
			  <option value ="2">高职</option>
            </select>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">一级专业</label>
            <select id='txt_yijizy' OnChange="yijizy()" class="form-control selectpicker"  data-live-search="true"></select>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">二级专业</label>
            <select id='txt_erjizy' OnChange="erjizy()" class="form-control selectpicker"  data-live-search="true"></select>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">三级专业</label>
             <select id='txt_sanjizy'  class="form-control selectpicker"  data-live-search="true"></select>
          </div>
        </div>    
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
          <button  type="submit" id="btn_submit1" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
        </div>
      </form>
    </div>
  </div>
  
  


  
    <script src="js/toastr.min.js"></script>
    <script src="js/bootstrap-table.js"></script>
    <script src="js/bootstrap-table-zh-CN.js"></script>
    <script src="js/bootstrap-table-export.js"></script>
    <script src="js/tableExport.js"></script>
    <script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script type="text/javascript" src="js/xx_xyzy_sz.js"></script>

  </body>
</html>
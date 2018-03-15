<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>学校管理</title>
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
  <legend>学校操作员管理</legend>
			
                  <div class="btn-group " id="toolbar">
                        
				           <div class="btn-group">
								  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    添加 <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu">
								    <li><a id="btn_add1">添加学校管理员</a></li>
								    <li><a id="btn_add2">添加学院管理员</a></li>								 
								  </ul>
								</div>  
				            
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

   <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;">
    <div class="modal-dialog" role="document">
      <form id="defaultForm1" class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
          <h4 class="modal-title" id="myModalLabel">添加学校管理员</h4>
        </div>
        <div class="modal-body">
        <div class="form-group">
            <label for="txt_departmentlevel">单位名称</label>
            <input type="text" name="txt_xxxm" class="form-control" id="txt_xxxm" placeholder="${user.xxxm}" disabled>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">操作员姓名</label>
            <input type="text" name="txt_lxr" class="form-control" id="txt_lxr" placeholder="">
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">操作员工号</label>
            <input type="text" name="txt_czygh" class="form-control" id="txt_czygh" placeholder="系统自动生成" disabled>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">操作员口令</label>
            <input type="text" name="txt_czykl" class="form-control" id="txt_czykl" placeholder="12345678" disabled>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">联系电话</label>
            <input type="text" name="txt_lxdh" class="form-control" id="txt_lxdh" placeholder="请准确输入电话号码，以方便联系填报人纠正填报数据的失误">
          </div>
        </div>    
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
          <button  type="submit" id="btn_submit1" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
        </div>
      </form>
    </div>
  </div>
  
  <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;">
    <div class="modal-dialog" role="document">
      <form id="defaultForm2" class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
          <h4 class="modal-title" id="myModalLabel">添加学院管理员</h4>
        </div>
        <div class="modal-body">
        <div class="form-group">
            <label for="txt_departmentlevel">学院名称</label>
            <select id='txt_xyxm' class="form-control selectpicker"  data-live-search="true"></select>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">操作员姓名</label>
            <input type="text" name="txt_lxr1" class="form-control" id="txt_lxr1" placeholder="">
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">操作员工号</label>
            <input type="text" name="txt_czygh1" class="form-control" id="txt_czygh1" placeholder="系统自动生成" disabled>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">操作员口令</label>
            <input type="text" name="txt_czykl1" class="form-control" id="txt_czykl1" placeholder="12345678" disabled>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">联系电话</label>
            <input type="text" name="txt_lxdh1" class="form-control" id="txt_lxdh1" placeholder="请准确输入电话号码，以方便联系填报人纠正填报数据的失误">
          </div>
        </div>    
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
          <button  type="submit" id="btn_submit2" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
        </div>
      </form>
    </div>
  </div>

<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;">
    <div class="modal-dialog" role="document">
      <form id="defaultForm3" class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
          <h4 class="modal-title" id="myModalLabel">添加教育厅管理员</h4>
        </div>
        <div class="modal-body">
        <div class="form-group">
            <label for="txt_departmentlevel">单位名称</label>
            <input type="text" name="txt_xxxm3" class="form-control" id="txt_xxxm3" placeholder="" disabled>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">操作员姓名</label>
            <input type="text" name="txt_lxr3" class="form-control" id="txt_lxr3" placeholder="">
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">操作员工号</label>
            <input type="text" name="txt_czygh3" class="form-control" id="txt_czygh3" placeholder="" disabled>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">操作员口令</label>
            <input type="text" name="txt_czykl3" class="form-control" id="txt_czykl3" placeholder="12345678" disabled>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">联系电话</label>
            <input type="text" name="txt_lxdh3" class="form-control" id="txt_lxdh3" placeholder="请准确输入电话号码，以方便联系填报人纠正填报数据的失误">
          </div>
        </div>    
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
          <button  type="submit" id="btn_submit3" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
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
    <script type="text/javascript" src="js/xx_czy_gl.js"></script>
        <script type="text/javascript">
    $("#myModal1").on("hide.bs.modal", function () {
    	document.getElementById("defaultForm1").reset();
    	$("#defaultForm1").data('bootstrapValidator').resetForm();
    	});
    $("#myModal2").on("hide.bs.modal", function () {
    	document.getElementById("defaultForm2").reset();
    	$("#defaultForm2").data('bootstrapValidator').resetForm();
    	});
    $("#myModal3").on("hide.bs.modal", function () {
    	document.getElementById("defaultForm3").reset();
    	$("#defaultForm3").data('bootstrapValidator').resetForm();
    	});
    </script>
  </body>
</html>
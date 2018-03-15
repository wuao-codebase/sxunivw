<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>陕西省高等学校专业普查数据填报表</title>
<%@ include file="navigation.jsp" %>
<link rel="stylesheet" href="css/ladda-themeless.min.css">
	 <link href="css/fileinput.min.css" rel="stylesheet">
	 <link href="css/paper-bootstrap-wizard.css" rel="stylesheet" />
	 <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
	 <link rel="stylesheet" href="css/toastr.min.css">
	 <link href="css/themify-icons.css" rel="stylesheet">
	 
	 <link rel="stylesheet" href="css/bootstrap-table.css">
  	     <link rel="stylesheet" href="css/bootstrapValidator.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-select.css">
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
		                        	<h3 class="wizard-title">专科专业信息填报表</h3>
		                    	</div>
								<div class="wizard-navigation">
									<div class="progress-with-circle">
									    <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="4" style="width: 15%;"></div>
									</div>
									<ul>
			                            <li>
											<a style="pointer-events: none;" href="#tab1" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-direction"></i>
												</div>
												专业情况
											</a>
										</li>
			                            <li>
											<a  style="pointer-events: none;" href="#tab2" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-book"></i>
												</div>
												学生
											</a>
										</li>
										<li>
											<a style="pointer-events: none;" href="#tab5" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-pencil-alt"></i>
												</div>
												教学条件与培养方案
											</a>
										</li>
			                        </ul>
								</div>
								<br>
		                        <div class="tab-content">
		                        
		                            <div class="tab-pane " id="tab1">
	                         		  <div class="form-group">
				                        <div class="group ">
				                            <label class="col-sm-2  control-label">学校:</label>
				                            <div class="col-sm-3">
				                                <input  type="text"  class="form-control" name=""  placeholder="${user.xxxm}" disabled />
				                            </div>
				                        </div>
				                        <div class="group ">
				                            <label class="col-sm-2 control-label">教学单位:</label>
				                            <div class="col-sm-3">
				                                <input  type="text"   class="form-control" name="" placeholder="${user.xyxm}"  disabled/>
				                            </div>
				                        </div>     	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">专业层次:</label>
				                            <div class="col-sm-3">
				                                <input  type="text"   class="form-control" name="" placeholder="专科" disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">专业名称:</label>
				                            <div class="col-sm-5">
				                               <select id='txt_zyxm' class="form-control" onchange="fresh()" name="ZYDM" required>
				                               <option disabled="" selected="">- 请选择 -</option>
				                               </select>
				                            </div>
				                        </div>      	
				                    </div>
				                     <div class="form-group">
				                       <div class="group">
				                            <label class="col-sm-2 control-label">优势专业类型:</label>
				                            <div class="col-sm-3">
				                               <select  class="form-control"  data-live-search="true" name="YSZYLX" required >
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="3">国家特色专业</option>
													<option value ="2">国家综合改革试点专业</option>
													<option value ="1">省部级优势专业</option>
													<option value ="0">无</option>
												</select>
				                            </div>
				                        </div>   
				                        <div class="group">
				                            <label class="col-sm-2 control-label">是否具有大专授予权:</label>
				                            <div class="col-sm-3">
				                                <select  class="form-control"  data-live-search="true" name="XWSYQ" required>
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="1">是</option>
													<option value ="0">否</option>
												</select>
				                            </div>
				                        </div>      	
				                    </div>
		                        </div>
		                            
		                            <div class="tab-pane" id="tab2">
		                          		                             <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">在校生总数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1"   value="0" max="5000" maxlength="4" class="form-control" name="ZXSRS" id="ZXSRS" required/>
				                            </div>
				                        </div>
				                         <div class="group">
				                            <label class="col-sm-2 control-label">境内学生数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1"   value="0" max="5000" maxlength="4" class="form-control" name="JNZRS" id="JNZRS" required/>
				                            </div>
				                        </div>   	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">港澳台侨学生数输入:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1"   value="0" maxlength="3" max="500" class="form-control" name="GATZRS"  id="GATZRS" required/>
				                            </div>
				                        </div>
				                         <div class="group">
				                            <label class="col-sm-2 control-label">留学生数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1"   value="0" maxlength="3" max="300" class="form-control" name="LXSZRS" id="LXSZRS" required/>
				                            </div>
				                        </div>   	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">实际录取数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="0" maxlength="4" class="form-control" name="SJLQS" required/>
				                            </div>
				                        </div>
				                         <div class="group">
				                            <label class="col-sm-2 control-label">当年招生人数(实际报道数):</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="0" maxlength="4" class="form-control" name="SJZSRS" required/>
				                            </div>
				                        </div>  	
				                    </div>
				                         <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">自主招生数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="0" maxlength="4" class="form-control" name="ZZZSRS" required/>
				                            </div>
				                        </div>
				                         <div class="group">
				                            <label class="col-sm-2 control-label">招生特长生数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="0" maxlength="4" class="form-control" name="ZTCSRS" required/>
				                            </div>
				                        </div>  	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年参加国际级学科竞赛人数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="0" maxlength="4" class="form-control" name="SJXKJSCJRS" required/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年参加国际级学科竞赛获奖人次:</label>
				                            <div class="col-sm-3">
				                                <input  type="text"  digits="1" value="0" maxlength="4"  class="form-control" name="SJXKJSHJRS" required/>
				                            </div>
				                        </div>      	
				                    </div>
				                      <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年参加文体竞赛获奖人次:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="0" maxlength="4" class="form-control" name="WTJSHJRS" required/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年参加国际会议人次:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1"  value="0" maxlength="4"  class="form-control" name="GJHYRS" required/>
				                            </div>
				                        </div>      	
				                    </div>
				                      <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">学生入党积极分子数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="0" maxlength="4" max="5000" class="form-control" name="XSRDJJFZ" required/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >学生预备党员数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="0" maxlength="4" max="5000" class="form-control" name="XSYBDYS" required/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">学生正式党员数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="0" maxlength="4" max="5000" class="form-control" name="XSZSDYS" required/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >学生参加公益活动人次:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="0" maxlength="5" max="50000" class="form-control" name="XSCJGYHDRS" required/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">校级以上（含校级）学生干部人数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="0" maxlength="2" max="20" class="form-control" name="XJXSGBRS" required/>
				                            </div>
				                        </div>
				                         <div class="group">
				                            <label class="col-sm-2 control-label"> 杰出校友人数:</label>
				                           <div class="col-sm-3">
				                           	<input  type="text" digits="1" value="0" maxlength="3" max="500" class="form-control" name="JCXYRS"  readonly required/>
				                     		  </div>
				                     		  <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">点击添加详细信息</button>
				                        </div>
				                    </div>
									<div class="collapse" id="collapseExample">
									  <div class="well">
									<div class="btn-group " id="toolbar">
				            			<button id="btn_add" type="button" class="btn btn-primary" >
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
									  </div>
									</div>
		                            </div>
		                            
		                             <div class="tab-pane" id="tab5">
		                             <div class="form-group">
				                       	   <div class="group">
				                            <label class="col-sm-2 control-label">上次培养方案修订年份:</label>
				                            <div class="col-sm-3">
				                                 <div class="input-group">
											          <input type="text" class="form-control form_datetime" id="pytime" name="PYFAXDNF" required >
											          <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
											       </div>
				                            </div>
				                        </div>    
				                    </div> 
		                        </div>
		                        
		                        <div class="wizard-footer">
	                            	<div class="pull-right">
	                                    <input type='button' class='btn btn-next btn-fill btn-success btn-wd' name='next' value='下一步' />
										<button type='button' id="finish"  class="btn btn-finish btn-fill btn-primary btn-wd ladda-button"  name='finish' data-style="contract"><span class="ladda-label">保存</span></button>	
									</div>

	                                <div class="pull-left">
	                                    <input type='button' class='btn btn-previous btn-default btn-wd' name='previous' value='返回' />
	                                </div>
	                                <div class="clearfix"></div>
		                        </div>
		                        
		                    </form>
		                </div>
		            </div> <!-- wizard container -->
		        </div>
	        </div> <!-- row -->
	    </div> <!--  big container -->


	 <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;">
    <div class="modal-dialog" role="document">
      <form id="defaultForm1" class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
          <h4 class="modal-title" id="myModalLabel">添加</h4>
        </div>
        <div class="modal-body">
        <div class="form-group" style="display: none;">
            <label for="txt_departmentlevel" >ID</label>
            <input type="text" name="id" class="form-control" id="id" placeholder="" >
          </div>
        <div class="form-group">
            <label for="txt_departmentlevel">校友姓名</label>
            <input type="text" name="xyxm" class="form-control" id="xyxm" placeholder="" >
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">性别</label>
            <select  class="form-control"  data-live-search="true" name="xb" id="xb"  >
	            <option disabled="" selected="">- 请选择 -</option>
	            <option value ="1">男</option>
				<option value ="0">女</option>
			</select>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">入学年份</label>
            <div class="input-group">
	          <input type="text" class="form-control form_datetime" id="rxnf" name="rxnf" required >
	          <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
	       </div>
          </div>
          <div class="form-group">
            <label for="txt_departmentlevel">工作单位</label>
            <input type="text" name="gzdw" class="form-control" id="gzdw" placeholder="" >
          </div>
           <div class="form-group">
            <label for="txt_departmentlevel">从事行业</label>
            <select id='yijizy' OnChange="yijizyb()" class="form-control selectpicker"  data-live-search="true"></select>
          </div>
          <div class="form-group">
             <select id='erjizy'  class="form-control selectpicker"  data-live-search="true"></select>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
          <button  type="submit"  id="btn_submit1" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
        </div>
      </form>
    </div>
  </div>
  
  
                     
	</div>
	<script src="js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
	<script src="js/xy_zkzyxxupbu.js" type="text/javascript"></script>
	<script src="js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="js/bootstrap-datetimepicker.min.js"></script>
    <script src="js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="js/toastr.min.js"></script>
    <script src="js/spin.min.js"></script>
	<script src="js/ladda.min.js"></script>
	
	<script src="js/bootstrap-table.js"></script>
    <script src="js/bootstrap-table-zh-CN.js"></script>
    <script src="js/bootstrap-table-export.js"></script>
    <script src="js/tableExport.js"></script>
    <script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script src="js/Xyxxgl.js"></script> 
	<script type="text/javascript">
	$(function () {
	
		
	  $('[data-toggle="tooltip"]').tooltip()
	  
	
	})
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
		
        jQuery.validator.addMethod("minNumber",function(value, element){
            var returnVal = true;
            inputZ=value;
            var ArrMen= inputZ.split(".");    //截取字符串
            if(ArrMen.length==2){
                if(ArrMen[1].length>2){    //判断小数点后面的字符串长度
                    returnVal = false;
                    return false;
                }
            }
            return returnVal;
        },"小数点后最多为两位");         //验证错误信息

        jQuery.validator.addMethod("minNumber1",function(value, element){
            var returnVal = true;
            inputZ=value;
            var ArrMen= inputZ.split(".");    //截取字符串
            if(ArrMen.length==2){
                if(ArrMen[1].length>1){    //判断小数点后面的字符串长度
                    returnVal = false;
                    return false;
                }
            }
            return returnVal;
        },"小数点后最多为一位");         //验证错误信息

  
</script>

  </body>
</html>
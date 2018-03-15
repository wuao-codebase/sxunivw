<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>陕西省高等学校专业普查数据导出表</title>
<%@ include file="navigation.jsp" %>
	 <link href="css/fileinput.min.css" rel="stylesheet">
	 <link href="css/paper-bootstrap-wizard.css" rel="stylesheet" />
	 <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
	 <link rel="stylesheet" href="css/toastr.min.css">
	 <link href="css/themify-icons.css" rel="stylesheet">
	  <link rel="stylesheet" href="css/bootstrap-select.css">
	  <link rel="stylesheet" href="css/bootstrap-table.css">
  	     <link rel="stylesheet" href="css/bootstrapValidator.min.css"/>
	 
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
		                 <form action="" method="" class="form-horizontal" >
		                <div class="form-group">
		                    			<div class="group ">
				                            <label class="col-sm-1  control-label">学院:</label>
				                            <div class="col-sm-3" >
				                                <select id='txt_xyxm'  OnChange="zymc()" class="form-control selectpicker"  data-live-search="true"></select>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">专科专业:</label>
				                            <div class="col-sm-5">
				                                <select id='txt_zymc'  class="form-control selectpicker"  data-live-search="true"></select>
				                            </div>
				                            <button type="button" onclick="find();fresh()" class="btn btn-default">查 询</button>
				                        </div> 
				                    </div>
				            </form>
		                <form action="Zkpdf" method="post" class="form-horizontal" id="forms">
		                <!--        You can switch " data-color="green" "  with one of the next bright colors: "bue", "azure", "orange", "red"       -->

		                    	<div class="wizard-header">
		                        	<h3 class="wizard-title">专科专业信息导出表</h3>
		                    	</div>
								<div class="wizard-navigation">
									<div class="progress-with-circle">
									    <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="4" style="width: 15%;"></div>
									</div>
									<ul>
			                            <li>
											<a class="a" href="#tab1" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-direction"></i>
												</div>
												专业情况
											</a>
										</li>
			                            <li>
											<a  class="a" href="#tab2" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-book"></i>
												</div>
												学生
											</a>
										</li>
			                            <li>
											<a class="a" href="#tab3" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-panel"></i>
												</div>
												师资
											</a>
										</li>
			                            <li>
											<a class="a" href="#tab4" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-user"></i>
												</div>
												科学研究
											</a>
										</li>
										<li>
											<a class="a" href="#tab5" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-pencil-alt"></i>
												</div>
												教学条件与培养方案
											</a>
										</li>
										<li>
											<a class="a" href="#tab6" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-map"></i>
												</div>
												教学改革
											</a>
										</li>
										<li>
											<a class="a" href="#tab7" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-ruler-alt-2"></i>
												</div>
												创新创业
											</a>
										</li>
										<li>
											<a class="a" href="#tab8" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-marker-alt"></i>
												</div>
												质量保障
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
				                                <input  type="text" id="xxmc"  class="form-control" name="XXMC"  value="${user.xxxm}" readonly />
				                            </div>
				                        </div>
				                         <div class="group" style="display: none;">
				                            <label class="col-sm-2 control-label">学校代码:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" id="xxdm"  class="form-control"  value="${user.xxdm}" name="XXDM" />
				                            </div>
				                        </div>  
				                       <div class="group ">
				                            <label class="col-sm-2 control-label">教学单位:</label>
				                            <div class="col-sm-3">
				                               <input  type="text"  id="xymc" class="form-control" name="XYMC"   readonly/>
				                            </div>
				                        </div> 
				                        <div class="group" style="display: none;">
				                            <label class="col-sm-2 control-label">学院代码:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" id="xydm"  class="form-control" name="XYDM" />
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">专业层次:</label>
				                            <div class="col-sm-3">
				                                <input  type="text"   class="form-control" name="" placeholder="专科" readonly/>
				                            </div>
				                        </div>
				                      <div class="group">
				                            <label class="col-sm-2 control-label">专业名称:</label>
				                            <div class="col-sm-5">
				                               <input  type="text" id="zymc"  class="form-control" name="ZYMC"  required readonly/>
				                            </div>
				                        </div> 
				                         <div class="group" style="display: none;">
				                            <label class="col-sm-2 control-label">专业代码:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" id="zydm"  class="form-control" name="ZYDM" />
				                            </div>
				                        </div>            	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">专业设置年限:</label>
				                            <div class="col-sm-3">
				                            	    <div class="input-group">
											          <input type="text" class="form-control form_datetime"  name="ZYBXRQ" required disabled >
											          <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
											        </div>
											 </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">省级专业综合改革试点标志:</label>
				                            <div class="col-sm-3">
				                                <select  class="form-control"  data-live-search="true" name="SJZHGGBZ" required disabled >
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="1">有</option>
													<option value ="0">无</option>
												</select>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">创新行动计划项目数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="2" class="form-control" name="CXFAXMS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">陕西省一流专业:</label>
				                            <div class="col-sm-3">
				                                <select  class="form-control"  data-live-search="true" name="SXYLZYBZ" required disabled >
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="2">有</option>
										            <option value ="1">培养</option>
													<option value ="0">无</option>
												</select>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                       <div class="group">
				                            <label class="col-sm-2 control-label">优势专业类型:</label>
				                            <div class="col-sm-3">
				                               <select  class="form-control"  data-live-search="true" name="YSZYLX" required disabled>
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="2">国家特色专业</option>
													<option value ="1">国家综合改革试点专业</option>
													<option value ="0">省部级优势专业</option>
												</select>
				                            </div>
				                        </div>   
				                        <div class="group">
				                            <label class="col-sm-2 control-label">是否具有学士授予权:</label>
				                            <div class="col-sm-3">
				                                <select  class="form-control"  data-live-search="true" name="XWSYQ" required disabled>
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="1">是</option>
													<option value ="0">否</option>
												</select>
				                            </div>
				                        </div>      	
				                    </div>
				                     <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">专业认证（评估）:</label>
				                           <div class="col-sm-3">
				                                <select  class="form-control"  data-live-search="true" name="GCRZBZ" required disabled >
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="1">通过</option>
													<option value ="0">未通过</option>
												</select>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年转入人数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" max="600" maxlength="3" class="form-control" name="ZCRS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年转出本专业人数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" max="600" maxlength="3" class="form-control" name="ZRRS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年应届毕业生研究生录取人数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" class="form-control" name="YJSLQRS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                        <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年本专业接收留学生人数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" class="form-control" name="JSLXSRS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年学生出国（境）学习人数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4"class="form-control" name="SCLXSRS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">毕业生初次就业率平均值:</label>
				                           <div class="col-sm-3">
				                                <div class="input-group">
											      <input type="text" maxlength="5" max="100"  minNumber="1" value="" class="form-control" name="BYSCCJYL"  required disabled>
											      <div class="input-group-addon">%</div>
											    </div>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">学生对用人单位的满意率:</label>
				                            <div class="col-sm-3">
				                            	<div class="input-group">
											      <input type="text"maxlength="5" max="100"  minNumber="1" value="" class="form-control" name="BYSMYD" required disabled>
											      <div class="input-group-addon">%</div>
											    </div>
				                            </div>
				                        </div>      	
				                    </div>
				                      <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年毕业生自主创业人数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="2" class="form-control" name="ZZCYRS" required disabled/>
				                            </div>
				                        </div>
				                    </div>
		                        </div>
		                            
		                            <div class="tab-pane" id="tab2">
		                     <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">在校生总数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="5" class="form-control" name="ZXSRS" required disabled/>
				                            </div>
				                        </div>
				                         <div class="group">
				                            <label class="col-sm-2 control-label">境内学生数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="5" class="form-control" name="JNZRS" required disabled/>
				                            </div>
				                        </div>  
				                    </div>
				                     <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">港澳台侨学生数输入:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" max="5000" class="form-control" name="GATZRS" required disabled/>
				                            </div>
				                        </div>
				                         <div class="group">
				                            <label class="col-sm-2 control-label">留学生数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" max="5000" class="form-control" name="LXSZRS" required disabled/>
				                            </div>
				                        </div>   	
				                    </div>
				                         <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">实际录取数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" class="form-control" name="SJLQS" required disabled/>
				                            </div>
				                        </div>
				                          <div class="group">
				                            <label class="col-sm-2 control-label">当年计划招生人数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" class="form-control" name="JHZSRS" required disabled/>
				                            </div>
				                        </div>  	
				                    </div>
				                     <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">自主招生数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" class="form-control" name="ZZZSRS" required disabled/>
				                            </div>
				                        </div>
				                         <div class="group">
				                            <label class="col-sm-2 control-label">招生特长生数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" class="form-control" name="ZTCSRS" required disabled/>
				                            </div>
				                        </div>  	
				                    </div>
				                    
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年招生人数(实际报道数)::</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" class="form-control" name="SJZSRS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年在陕当年招生人数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" class="form-control" name="ZSZSRS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                        <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年在陕最高分:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" class="form-control" name="ZSZGF" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年在陕最低分:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" class="form-control" name="ZSZDF" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group" style="display: none;">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年在陕最高位次:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="5" class="form-control" name="ZSZGWC" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年在陕最低位次:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="6" class="form-control" name="ZSZDWC" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年在陕招生平均分:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  maxlength="3" class="form-control" name="ZSPJF" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group" style="display: none;">
				                            <label class="col-sm-2 control-label">当年在陕招生平均位次:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="6" class="form-control" name="ZSPJWC" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <legend></legend>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年参加国际级学科竞赛人数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" class="form-control" name="SJXKJSCJRS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年参加国际级学科竞赛获奖人次:</label>
				                            <div class="col-sm-3">
				                                <input  type="text"  digits="1" value="" maxlength="4"  class="form-control" name="SJXKJSHJRS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                      <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年参加文体竞赛获奖人次:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" class="form-control" name="WTJSHJRS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年参加国际会议人次:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1"  value="" maxlength="4"  class="form-control" name="GJHYRS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年参加国家级技能竞赛人数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" class="form-control" name="GJJNJSCJRS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年参加省级技能竞赛人数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" digits="1" value="" maxlength="4" max="3000" class="form-control" name="SXJNJSCJRS" data-toggle="tooltip" data-placement="top" title="不含互联网+大赛" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年参加国家级技能竞赛获奖人次:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" class="form-control" name="GJJNJSDJS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" > 陕西技能竞赛得奖人数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" max="3000" class="form-control" name="SXXKJSDJS" data-toggle="tooltip" data-placement="top" title="不含互联网+大赛" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">上一年度学生参加互联网+大赛获国家级奖人数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" class="form-control" name="SNGJHLWDJS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >上一年度学生参加互联网+大赛获省级奖人数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" class="form-control" name="SNSXHLWDJS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年主持的国家级大学生创新创业训练项目立项数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" class="form-control" name="GJDCS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年主持的省级大学生创新创业训练项目立项数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" class="form-control" name="SJDCS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                      <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">论文数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="800" class="form-control" name="LWS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >专利数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="300" class="form-control" name="ZLS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
		                               <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">高等学校英语应用能力考试A级通过率:</label>
				                           <div class="col-sm-3">
				                                <div class="input-group">
											      <input type="text" class="form-control" name="YINGYUA" maxlength="5" max="100"  minNumber="1" value=""  required disabled>
											      <div class="input-group-addon">%</div>
											    </div>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">高等学校英语应用能力考试B级通过率:</label>
				                            <div class="col-sm-3">
				                            	<div class="input-group">
											      <input type="text" class="form-control" name="YINGYUB" maxlength="5" max="100"  minNumber="1" value="" required disabled>
											      <div class="input-group-addon">%</div>
											    </div>
				                            </div>
				                        </div>      	
				                    </div> 
				                     <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">在校生获得省级及以上荣誉的人数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" class="form-control" name="SJJLS" maxlength="4" max="2000"  data-toggle="tooltip" data-placement="top" title="不含学科竞赛获奖" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >在校生获得各级奖学金人数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" class="form-control" name="JXJS" maxlength="4" max="2000" data-toggle="tooltip" data-placement="top" title="不含助学金" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>  
 									<div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">职业资格证书获取率:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" class="form-control" name="ZYZSHQL" maxlength="4" max="2000"  data-toggle="tooltip" data-placement="top" title="不含学科竞赛获奖" required disabled/>
				                            </div>
				                        </div>
				                    </div>  
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">学生入党积极分子数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" max="5000" class="form-control" name="XSRDJJFZ" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >学生预备党员数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" max="5000" class="form-control" name="XSYBDYS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">学生正式党员数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" max="5000" class="form-control" name="XSZSDYS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >学生参加公益活动人次:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="5" max="50000" class="form-control" name="XSCJGYHDRS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">校级以上（含校级）学生干部人数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="2" max="20" class="form-control" name="XJXSGBRS" required disabled/>
				                            </div>
				                        </div>
				                      <div class="group">
				                            <label class="col-sm-2 control-label"> 杰出校友人数:</label>
				                           <div class="col-sm-3">
				                           	<input  type="text" digits="1" value="0" maxlength="3" max="500" class="form-control" name="JCXYRS" required disabled/>
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
		                            
		                         <div class="tab-pane" id="tab3">
		                            <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">专职教师数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" max="1000" class="form-control" name="JSZS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >正高职称教师数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" max="1000" class="form-control" name="ZGJSZS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">副高职称教师数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" class="form-control" maxlength="4" max="1000" name="FGJSZS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >外聘教师数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" class="form-control" maxlength="3" max="200" name="WPJSZS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">36-45岁（含）年龄教师数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="500" class="form-control" name="YOUNGJSZS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >35岁（含）以下年龄教师数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="500" class="form-control" name="MEDIANJSZS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">具有博士学位的教师数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="4" max="1000" class="form-control" name="BSJSZS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >实验教师数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="100" class="form-control" name="SYJSZS" data-toggle="tooltip" data-placement="top" title="本专业教师中专业职实验教师人数" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
		                             <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年为专科生授课的正高职称教师数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="500" class="form-control" name="DNSKZGJSS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年教师参加各类国家级教学技能竞赛活动获奖人数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="500" class="form-control" name="DNGJJXJS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                         <div class="group">
				                            <label class="col-sm-2 control-label">国家级教学团队:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="100" class="form-control" name="GJJJXTDS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年参加各类省级教学技能竞赛活动获奖人数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="500" class="form-control" name="DNSJJXJS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				         
		                          </div>
		                            
		                            <div class="tab-pane" id="tab4">
		                             <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年教师获得国家级科技奖数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="100" class="form-control" name="DNGJKJJS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年教师获得省级科技奖数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="100" class="form-control" name="DNSJKJJS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                      <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年教师主持的国家级科研项目数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="500" class="form-control" name="DNGJJXMS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年教师主持的省部级科研项目数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value="" maxlength="3" max="500" class="form-control" name="DNSBXMS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                     <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年纵向科研项目到款经费总数:</label>
				                           <div class="col-sm-3">
				                                <div class="input-group">
											      <input type="text" class="form-control" name="DNZXDK" value="" minNumber="1" maxlength="8" max="100000" required disabled>
											      <div class="input-group-addon">万元</div>
											    </div>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年横向科研项目到款经费总数:</label>
				                            <div class="col-sm-3">
				                            	<div class="input-group">
											      <input type="text" class="form-control" name="DNHXDK" value=""  minNumber="1" maxlength="8" max="100000" required disabled>
											      <div class="input-group-addon">万元</div>
											    </div>
				                            </div>
				                        </div>      	
				                    </div> 
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">国家级科研团队:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="2" class="form-control" name="GJJKYTDS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >省级教学团队:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="2" class="form-control" name="SJJXTDS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">省级科研团队:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="2" class="form-control" name="SJKYTDS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年教师发表的SCI论文数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="3" class="form-control" name="DNSCI" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                     <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年教师发表的SSCI论文数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="3" class="form-control" name="DNSSCI" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年教师发表的CSSCI论文数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="3" class="form-control" name="DNCSSCI" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年教师发表的EI论文数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="3" class="form-control" name="DNEI" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年教师发表的CSCD论文数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="3" class="form-control" name="DNCSCD" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年教师发表的ISTP论文数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="3" class="form-control" name="DNISTP" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >当年教师获得的专利数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="3" class="form-control" name="DNZLS" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
				                    
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年教师获得软件著作权数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="3" class="form-control" name="DNRJZZQS" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >高水平教师人数:</label>
				                            <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="3" class="form-control" name="GSPJSS"  data-toggle="tooltip" data-placement="top" title="高水平教师指院士、长江学者奖励支持计划人选、国家杰出青年基金获得者、国务院及省级学科评议组成员、973（863）首席科学家、千人计划、新世纪百千万人才工程国家级人选、教育部新世纪优秀人才支持计划人选、中科院“百人计划”入选、国家及省级教学名师、国家及省优秀教师、国务院政府特殊津贴获得者、三秦学者、省政府部门行文公布确定的人才计划与教师荣誉。同一教师获得多项人才计划或荣誉时，就高计算，不重复。" required disabled/>
				                            </div>
				                        </div>      	
				                    </div>
									<div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年度教师出国培训进修的人数:</label>
				                           <div class="col-sm-3">
				                                <input  type="text" digits="1" value=""  digits="1" maxlength="3" class="form-control" name="DNCGFXS"  data-toggle="tooltip" data-placement="top" title="出国访问交流、学习、培训（不包含会议形式）" required disabled/>
				                            </div>
				                        </div>
				                    </div>
		                           </div>
		                            
		                             <div class="tab-pane" id="tab5">
		                             <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">专业教学仪器设备总值:</label>
				                           <div class="col-sm-3">
				                                <div class="input-group">
											      <input type="text" class="form-control" name="ZSBF" minNumber="1" value="" maxlength="7"  max="100000" required disabled>
											      <div class="input-group-addon">万元</div>
											    </div>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">教学专业软件总值:</label>
				                            <div class="col-sm-3">
				                            	<div class="input-group">
											      <input type="text" class="form-control" name="ZRJF" minNumber="1" value=""  maxlength="7"  max="100000" required disabled>
											      <div class="input-group-addon">万元</div>
											    </div>
				                            </div>
				                        </div>      	
				                    </div> 
				                     <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年新增教学仪器设备:</label>
				                           <div class="col-sm-3">
				                                <div class="input-group">
											      <input type="text" class="form-control" name="DNSBF" minNumber="1" value=""  maxlength="7"  max="100000" required disabled>
											      <div class="input-group-addon">万元</div>
											    </div>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年单独购置的教学专业软件总值:</label>
				                            <div class="col-sm-3">
				                            	<div class="input-group">
											      <input type="text" class="form-control" name="DNRJF" minNumber="1" value=""  maxlength="7"  max="100000" required disabled>
											      <div class="input-group-addon">万元</div>
											    </div>
				                            </div>
				                        </div>      	
				                    </div> 
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">平均专业图书册数:</label>
				                           <div class="col-sm-3">
				                                <div class="input-group">
		 										<input type="text" class="form-control" name="ZYTUSHU"  value="" digits="1"  maxlength="7"  data-toggle="tooltip" data-placement="top" title="含纸质、电子图书" required disabled>
											    
											    </div>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年教学经费:</label>
				                            <div class="col-sm-3">
				                            	<div class="input-group">
											      <input type="text" class="form-control" name="DNJXJF" minNumber="1" value=""  maxlength="7"  max="100000" placeholder="单位万元" required disabled>
											      <div class="input-group-addon">万元</div>
											    </div>
				                            </div>
				                        </div>      	
				                    </div> 
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">实践教学经费总支出:</label>
				                           <div class="col-sm-3">
				                                <div class="input-group">
											      <input type="text" class="form-control" name="SJJXJF" minNumber="1" value=""  maxlength="6"  max="10000" required disabled>
											      <div class="input-group-addon">万元</div>
											    </div>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">现有校外实习实训基地数:</label>
				                            <div class="col-sm-3">
											      <input digits="1" value=""   maxlength="3" type="text" class="form-control" name="XNSXJD" required disabled>
				                            </div>
				                        </div>      	
				                    </div> 
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">现有校内实习实训基地数:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""   maxlength="3" type="text" class="form-control" name="XWSXJD" required disabled>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">毕业论文（设计）来自省级以上课题和生产实际的比例:</label>
				                            <div class="col-sm-3">
											      <div class="input-group">
											      <input type="text" class="form-control" name="BYLWBL" maxlength="5" max="100"  minNumber="1" value="" required disabled>
											      <div class="input-group-addon">%</div>
											    </div>
				                            </div>
				                        </div>      	
				                    </div> 
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年订单班培养学生人数:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""   maxlength="4" type="text" class="form-control" name="DNDDBXSS" required disabled>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年现代学徒学生数量:</label>
				                            <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="4" type="text" class="form-control" name="DNXDXTS" required disabled>
				                            </div>
				                        </div>      	
				                    </div> 
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">国家级虚拟仿真实验教学中心数量:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="GJJXNZSS" required disabled>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">省级虚拟仿真实验教学中心数量:</label>
				                            <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="SJXNZSS" required disabled>
				                            </div>
				                        </div>      	
				                    </div> 
				                     <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年校企联合培养协议数:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="XQLHPYXYS" required disabled>
				                            </div>
				                        </div>
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">国家级实验室数量:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="GJJSYSS" required disabled>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">省级实验室数量:</label>
				                            <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="SJSYSS" required disabled>
				                            </div>
				                        </div>      	
				                    </div> 
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">国家级生产性实训基地数:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="GJJSCSXJDS" required disabled>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">省级生产性实训基地数:</label>
				                            <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="SJSCSXJDS" required disabled>
				                            </div>
				                        </div>      	
				                    </div> 
				                   <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">毕业要求的学分总数:</label>
				                           <div class="col-sm-3">
											      <input  value="" minNumber1="1" max="999" maxlength="5" type="text" class="form-control" name="BYXFZS" required disabled>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">理论课学分总数:</label>
				                            <div class="col-sm-3">
											      <input  value="" minNumber1="1" max="999" maxlength="5" type="text" class="form-control" name="LLXFZS" required disabled>
				                            </div>
				                        </div>      	
				                    </div> 
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">实践环节学分总数:</label>
				                           <div class="col-sm-3">
											      <input  value="" minNumber1="1" max="999" maxlength="5" type="text" class="form-control" name="SJKXFZS" required disabled>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">选修课学分总数:</label>
				                            <div class="col-sm-3">
											      <input  value="" minNumber1="1" max="999" maxlength="5" type="text" class="form-control" name="XXKXFZS" required disabled>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">创新学分数:</label>
				                           <div class="col-sm-3">
											      <input value="" minNumber1="1" max="999" maxlength="5" type="text" class="form-control" name="CXXFZS" required disabled >
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">上次培养方案修订年份:</label>
				                            <div class="col-sm-3">
				                                 <div class="input-group">
											          <input type="text" class="form-control form_datetime" id="pytime" name="PYFAXDNF" required disabled >
											          <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
											       </div>
				                            </div>
				                        </div>   
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">上传本专业培养方案:</label>
				                           <div class="col-sm-8">
											     <input id="file-1" name="filediscription" type="file" multiple class="form-control" />
				                            </div>
				                        </div>
				                    </div>
		                            </div>
		                            
		                             <div class="tab-pane" id="tab6">
		                             <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年教师主持的省级教学研究项目数:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="DNSJJXYJS" required disabled>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">国家级精品课程数量:</label>
				                            <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="DNGJJJPKCS" data-toggle="tooltip" data-placement="top" title="视频公开课、资源共享课、慕课" required disabled>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">省级精品课程数量:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="DNSJJPKCS" data-toggle="tooltip" data-placement="top" title="视频公开课、资源共享课、慕课" required disabled>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">教师获得国家级教学成果奖累计数:</label>
				                            <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="DNSJJXCGJS" required disabled>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年省级人才培养模式实验区个数:</label>
				                            <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="SJRCPYSYCS" required disabled>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">国家级教学资源库标志:</label>
				                           <div class="col-sm-3">
 												<select  class="form-control"  data-live-search="true" name="GJJJXZYKBZ" required disabled >
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="1">有</option>
													<option value ="0">无</option>
												</select>				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">省级教学资源库标志:</label>
				                            <div class="col-sm-3">
				                                <select  class="form-control"  data-live-search="true" name="SJJXZYKBZ" required disabled >
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="1">有</option>
													<option value ="0">无</option>
												</select>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年教师以第一署名单位发表的教研论文:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="DNJGLWS" required disabled>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年教师以学校为第一单位，公开出版国家级规划教材:</label>
				                            <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="DNGJJJCS" required disabled>
				                            </div>
				                        </div>      	
				                    </div>
				                     <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">省级优秀教材前三编者:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="DNSJYXJCS" required disabled>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">其他教材第一主编公开出版:</label>
				                            <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="DNQTJCS" required disabled>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年国家教学成果奖:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="DNGJJJXCGJ" required disabled>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年省级教学成果奖:</label>
				                            <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="DNSJJJXCGJ" required disabled>
				                            </div>
				                        </div>      	
				                    </div>
		                            </div>
		                            
		                             <div class="tab-pane" id="tab7">
		                            <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">是否实施了弹性学制:</label>
				                           <div class="col-sm-3">
				                                <select  class="form-control"  data-live-search="true" name="TXSZBZ" required disabled>
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="1">是</option>
													<option value ="0">否</option>
												</select>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label">是否开设了创新创业课程:</label>
				                            <div class="col-sm-3">
											      <select  class="form-control"  data-live-search="true" name="CYKCBZ" data-toggle="tooltip" data-placement="top" title="含专业导论课、专业发展前沿课" required disabled>
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="1">是</option>
													<option value ="0">否</option>
												</select>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">创新创业指导教师人数:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="CYZDJSRS" data-toggle="tooltip" data-placement="top" title="统计专职与兼职双创导师人数" required disabled>
				                            </div>
				                        </div>
				          				<div class="group">
				                            <label class="col-sm-2 control-label">当年教师到企业进行3个月以上挂职锻炼的人数:</label>
				                           <div class="col-sm-3">
											      <input digits="1" value=""  maxlength="2" type="text" class="form-control" name="GZRS" required disabled>
				                            </div>
				                        </div>
				                    </div>
				                
		                            </div>
		                            
		                             <div class="tab-pane" id="tab8">
		                                <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">当年学生对本专业教师评价平均分:</label>
				                           <div class="col-sm-3">
												<input  type="text" minNumber="1"  maxlength="5" max="100" value="" class="form-control" name="JXJDPJ" data-toggle="tooltip" data-placement="top" title="百分制" required disabled/>
				                            </div>
				                        </div>
				                        <div class="group">
				                            <label class="col-sm-2 control-label" >本专业是否拥有教学督导:</label>
				                            <div class="col-sm-3">
				                                <select  class="form-control"  data-live-search="true" name="JXDDBZ" required disabled>
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="1">是</option>
													<option value ="0">否</option>
												</select>
				                            </div>
				                        </div>      	
				                    </div>
				                    <div class="form-group">
				                        <div class="group">
				                            <label class="col-sm-2 control-label">质量标准文件是否齐全:</label>
				                           <div class="col-sm-3">
				                                <select  class="form-control"  data-live-search="true" name="ZLBZBZ" required disabled>
										            <option disabled="" selected="">- 请选择 -</option>
										            <option value ="1">是</option>
													<option value ="0">否</option>
												</select>
				                            </div>
				                        </div>
				                    </div>
                 
		                            </div>
		                        </div>
		                        
		                        <div class="wizard-footer">
	                            	<div class="pull-right">
	                                    <input type='button' class='btn btn-next btn-fill btn-success btn-wd' name='next' value='下一步' />
	                                    <input type='submit' id="finish" class='btn btn-finish btn-fill btn-primary btn-wd' name='finish' value='导出' />
										<input type="reset" style="display:none;" /> 
									
									</div>

	                                <div class="pull-left">
	                                    <input type='button' class='btn btn-previous btn-default btn-wd' name='previous' value='返回' />
	                                </div>
	                                <div class="clearfix"></div>
		                        </div>
		                        
		                    </form>
		                    <br>
		                   <form action="Filedownload" method="post" >
										 <div class="group">
				                            <label class="col-sm-2 control-label">下载专业培养方案:</label>
				                            <div class="col-sm-5">
											      <input  type="text"  class="form-control" name="PYFAURL"  readonly>
				                            </div>
				                             <button type="submit"  class="btn btn-default">下载</button>
				                             <input type="reset" style="display:none;" /> 
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
  
	<script src="js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
	<script src="js/xx_zkzyxxexport.js" type="text/javascript"></script>
	<script src="js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="js/bootstrap-datetimepicker.min.js"></script>
    <script src="js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script src="js/fileinput.min.js"></script>
  	<script src="js/fileinput-zh.js"></script>
    <script src="js/toastr.min.js"></script>
    
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
	
	$("#file-1").fileinput({
	      uploadUrl: '/sxunivw/simpleFileupload', // you must set a valid URL here else you will get an error
	      allowedFileExtensions : ['rar'],
	      language : 'zh',
	      showUpload : 1,
	      showRemove : 1,
	      browseClass: "btn btn-primary", //按钮样式
	      maxFileSize: 153600,
	      maxFileCount: 1,
	      enctype: 'multipart/form-data',
	      previewFileIcon: '<i class="glyphicon glyphicon-file"></i>',
	      allowedPreviewTypes: null, 
	      previewFileIconSettings: {
	          'rar': '<i class="glyphicon glyphicon-file"></i>',
	      },
	      validateInitialCount:true,
	      msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		});
	          
		$("#file-1").on("fileuploaded", function (event, data, previewId, index) {  
			       $("#file-1").text("1");
			     }); 
		
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

	  

</script>

  </body>
</html>
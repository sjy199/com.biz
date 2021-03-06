<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome/4.5.0/css/font-awesome.min.css" />
	

	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts.googleapis.com.css" />

		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css" />

		<script src="${pageContext.request.contextPath}/assets/js/ace-extra.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.4.min.js"></script>

		<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

		<script src="${pageContext.request.contextPath}/assets/js/jquery-ui.custom.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.easypiechart.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.sparkline.index.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.flot.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.flot.pie.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.flot.resize.min.js"></script>

		<!-- ace scripts -->
		<script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap-datetimepicker/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
	<link href="${pageContext.request.contextPath}/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="index.html" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    学生管理系统
                </small>
            </a>
        </div>
    </div><!-- /.navbar-container -->
</div>

<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.loadState('main-container')
        } catch (e) {
        }
    </script>

    <div id="sidebar" class="sidebar responsive ace-save-state">
        <script type="text/javascript">
            try {
                ace.settings.loadState('sidebar')
            } catch (e) {
            }
        </script>

        <%--侧边栏开始--%>
        <ul class="nav nav-list" style="top: 0px;">
					
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> 课程管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="${pageContext.request.contextPath}/subject/findAllSub.do?number=0&&size=2">
									<i class="menu-icon fa fa-caret-right"></i>
									课程信息
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> 学生信息管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="${pageContext.request.contextPath}/student/findAllStudent.do?number=0&&size=2">
									<i class="menu-icon fa fa-caret-right"></i>
									学生信息列表
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="${pageContext.request.contextPath}/addStudent.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									录入学生信息
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
								<a href="${pageContext.request.contextPath}/findAllScore.do?number=0&&size=2">
									<i class="menu-icon fa fa-caret-right"></i>
									学生分数管理
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> 班级管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="${pageContext.request.contextPath}/findAll.do?number=0&&size=2">
									<i class="menu-icon fa fa-caret-right"></i>
									班级信息
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>
				</ul>
        <%--侧边栏结束--%>
        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
				
    </div>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>

                    <li>
                        <a href="#">学生信息管理</a>
                    </li>
                    <li class="active">学生信息列表</li>
                </ul><!-- /.breadcrumb -->

                <div class="nav-search" id="nav-search">
                    <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input"
                                           id="nav-search-input" autocomplete="off"/>
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
                    </form>
                </div><!-- /.nav-search -->
            </div>

            <div class="page-content">
                <!-- 表单开始 -->
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="student-table" class="table  table-bordered table-hover">
											<thead>
												<tr>
													<th class="center">
														<label class="pos-rel">
															<input class="ace" type="checkbox">
															<span class="lbl"></span>
														</label>
													</th>
													<th class="detail-col">详情</th>
													<th>学号</th>
													<th>姓名</th>
													<th class="hidden-480">性别</th>

													<th>
														<i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
														平均分
													</th>
													<th class="hidden-480">选课</th>
													<th></th>
												</tr>
											</thead>

											<tbody>
										
											<c:forEach items="${StudentList}" var="list">
												<tr>
													<td class="center">
														<label class="pos-rel">
															<input class="ace" type="checkbox">
															<span class="lbl"></span>
														</label>
													</td>
													<td class="center">
														<div class="action-buttons">
															<a href="#" class="green bigger-140 show-details-btn" title="Show Details">
																<i class="ace-icon fa fa-angle-double-down"></i>
																<span class="sr-only">Details</span>
															</a>
														</div>
													</td>

													<td>
														<a href="#">${list.studentid }</a>
													</td>
													<td>${list.name }</td>
													<td class="hidden-480">${list.sex }</td>
													<td>${list.avgscore }</td>
													
													
													<td class="hidden-480">
														<a href="javascript:void(0)" onclick="addSubject(${list.id})">
														<input id="sub_${list.id}" type="hidden" value="<c:forEach items="${list.subject }" var="s">${s },</c:forEach>">
															
															<span class="label label-sm label-warning">选课</span></a>
													</td>

													<td>
														<div class="hidden-sm hidden-xs btn-group">
															<button class="btn btn-xs btn-info" onclick="edit(${list.id})">
																<i class="ace-icon fa fa-pencil bigger-120"></i>
															</button>
															<button class="btn btn-xs btn-danger" onclick="del(${list.id})">
																<i class="ace-icon fa fa-trash-o bigger-120"></i>
															</button>
														</div>

														<div class="hidden-md hidden-lg">
															<div class="inline pos-rel">
																<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto">
																	<i class="ace-icon fa fa-cog icon-only bigger-110"></i>
																</button>

																<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
																	<li>
																		<a href="#" class="tooltip-info" data-rel="tooltip" title="" data-original-title="View">
																			<span class="blue">
																				<i class="ace-icon fa fa-search-plus bigger-120"></i>
																			</span>
																		</a>
																	</li>

																	<li>
																		<a href="#"  class="tooltip-success" data-rel="tooltip" title="" data-original-title="Edit">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
																		</a>
																	</li>

																	<li>
																		<a href="#" class="tooltip-error" data-rel="tooltip" title="" data-original-title="Delete">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
																		</a>
																	</li>
																</ul>
															</div>
														</div>
													</td>
												</tr>
											
													<tr class="detail-row">
													<td colspan="8">
														<div class="table-detail">
															<div class="row">
																<div class="col-xs-12 col-sm-2">
																	<div class="text-center">
																		<img class="thumbnail inline no-margin-bottom" alt="Domain Owner's Avatar" src="${pageContext.request.contextPath}/${list.img }" height="150">
																		<br>
																		<div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
																			<div class="inline position-relative">
																				<a class="user-title-label" href="#">
																					<i class="ace-icon fa fa-circle light-green"></i>
																					&nbsp;
																					<span class="white">${list.name }</span>
																				</a>
																			</div>
																		</div>
																	</div>
																</div>

																<div class="col-xs-12 col-sm-7">
																	<div class="space visible-xs"></div>

																	<div class="profile-user-info profile-user-info-striped">
																		<div class="profile-info-row">
																			<div class="profile-info-name"> studentName </div>

																			<div class="profile-info-value">
																				<span>${list.name }</span>
																			</div>
																		</div>

																		<div class="profile-info-row">
																			<div class="profile-info-name"> birthDay </div>

																			<div class="profile-info-value">
																				<span>${list.birthday }</span>
																			</div>
																		</div>

																		<div class="profile-info-row">
																			<div class="profile-info-name"> subject </div>

																			<div class="profile-info-value">
																			<span>
																			<c:forEach items="${list.subject }" var="s">
																				${s }&nbsp
																				
																			</c:forEach>
																			</span>
																			</div>
																		</div>

																		<div class="profile-info-row">
																			<div class="profile-info-name"> avgscore </div>

																			<div class="profile-info-value">
																				<span>${list.avgscore }</span>
																			</div>
																		</div>

																		<div class="profile-info-row">
																			<div class="profile-info-name"> grade </div>

																			<div class="profile-info-value">
																				<span>${list.grade }</span>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</td>
												</tr>
												</c:forEach>
											</tbody>
										</table>
                                <%--分页列表--%>
                                 <select id="size" style="float:right;">
                                 <option value="2">每页显示数</option>
                        <option>2</option>
                        <option>5</option>
                        <option>10</option>
                        
                        </select>
                                  <input name="size" type="hidden" value="${size }"><input name="totalPages" type="hidden" value="${totalPages }" ><input name="number" type="hidden" value="${number }">
					<ul class="pagination">
					</ul>

                            </div><!-- /.span -->
                        </div><!-- /.row -->

                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>
    </div>
    <div class="modal fade" id="studentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
            </div>
            <div class="modal-body" >
            	<div class="input-group">
                    <div class="form-group">
                    <input name="id" type="hidden"  value="" style="border:none;"><br>
                    <label>学号:</label>
                    <input name="studentid" type="text"  value="" style="border:none;"><br>
                    <label>姓名:</label>
                    <input name="name" type="text"  value=""  style="border:none;"><br>
                    <label>性别:</label>
                    <input name="sex" type="text"  value=""  style="border:none;"><br>
                    <label>生日:</label>
                    <input type="text" name="birthday" value="1999-01-01" data-date-format="yyyy-mm-dd" id="datetimepicker" style="margin-left:20px"><br>
                    <label>年级:</label>
                    <input name="grade" type="text"  value=""  style="border:none;"><br>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
            	<button id="submit" type="button" class="btn btn-info" data-dismiss="modal" >提交
                </button>
                <button id="close" type="button" class="btn btn-default" data-dismiss="modal" >关闭
                </button>
                
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="curricula-variable-Modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
            </div>
            <div class="modal-body" >
            	<select id="subject-select" class="form-control selectpicker" data-live-search="true">
            		<option value="0">点击选择课程</option>
            	</select>
            	<input name="subjectId" type="hidden">
            </div>
            <div class="modal-footer">
            	<button id="subjectSubmit" type="button" class="btn btn-info" data-dismiss="modal" style="float:left">提交
                </button>
                <button id="close" type="button" class="btn btn-default" data-dismiss="modal" >关闭
                </button>
                
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
<script type="text/javascript">

</script>

</html>
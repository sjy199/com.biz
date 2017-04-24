<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="jQuery/jquery-1.9.1.min.js"></script>
</head>
<body>
	<input id="addbutton" type="button" value="新增">
	<div id="add" style="display:none;">
	<form action="Addstudent">
	  &nbsp&nbsp&nbsp&nbsp&nbsp学生id：<input name="id" type="text"><br>
	学生名字：<input name="name" type="text"><br>
	学生生日：<br>
	            年：<input name="year" type="text">月：<input name="month" type="text">日：<input name="day" type="text"><br>
	
	描        述：<input name="description" type="text"><br>
	平均成绩：<input name="avgscore" type="text"><br>
	<input type="submit" value="提交">
	</form>
	
	</div>
	<table border="1" style="text-align:center">
	<tr>
		<td>学生id</td>
		<td>学生名字</td>
		<td>学生生日 </td>
		<td>描述 </td>
		<td>平均成绩</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list }" var="student" varStatus="vs">
		<tr>
		<td>${student.get(0) }</td>
		<td>${student.get(1) }</td>
		<td>${student.get(2).year+1990}.${student.get(2).month+1}.${student.get(2).date}</td>
		<td>${student.get(3)} </td>
		<td>${student.get(4)} </td>
		<td class="dosomething"><input type="button" onclick="update('${student.get(0) }','${student.get(1) }','${student.get(2).year+1990}','${student.get(2).month+1}','${student.get(2).date}','${student.get(3)}','${student.get(4)}')" value="修改">&nbsp&nbsp&nbsp
		<a href="DelStudent?name=${student.get(1) }">删除</a></td>
		</tr>
	</c:forEach>
	</table>
	<div id="page">
	</div>
	<div id="up" style="float:left;z-index:100px;margin-top:-200px;margin-left:500px;display:none;position:absolute;opacity:1; ">
	&nbsp&nbsp&nbsp&nbsp&nbsp学生id：<input name="id1" type="text"><br>
	学生名字：<input name="name1" type="text" readonly="true"><br>
	学生生日：<br>
	            年：<input name="year1" type="text">月：<input name="month1" type="text">日：<input name="day1" type="text"><br>
	
	描        述：<input name="description1" type="text"><br>
	平均成绩：<input name="avgscore1" type="text"><br>
	<input type="button" name="bc" value="保存">
	</div>
</body>
<script type="text/javascript">
	$("#addbutton").click(function(){
		var dis=$("#add").css("display");
		if(dis=="block"){
			$("#add").css("display","none");
		}
		else{
			$("#add").css("display","");
		}
		
	});
	$(document).ready(function(){
		var listsize=${listsize};
		
		var str="<input type='button' id='pre' value='上一页'>"
		for(var i=1;i<=(listsize/10+1);i++){
			str=str+"<input type='button' class='p' value='"+i+"'>";
		}
		str=str+"<input type='button' id='next' value='下一页'>"
		$("#page").append(str);
	}); 
	$("#page").delegate(".p","click",function(){
		page=$(this).val();
		window.location.href="ShowAllStudent?page="+page+"";
	})
	$("#page").delegate("#pre","click",function(){
		var page=${page};
		if(page>1){
			page=page-1;
			window.location.href="ShowAllStudent?page="+page+"";
		}
	})
	$("#page").delegate("#next","click",function(){
		var listsize=${listsize};
		var page=${page};
		if(page<(listsize/10+1)){
			page=page+1;
			window.location.href="ShowAllStudent?page="+page+"";
		}
	});
	  
	/* var del=function(){ 
		$(document).ready(function(){
			alert($(this).next().className); 
		})
			
			
			alert(1111)
		} */
		 function update(id,name,year,month,day,description,avgscore){
			var dis=$("#up").css("display");
			if(dis=="block"){
				$("#up").css("display","none");
			}
			else{
				$("#up").css("display","");
			}
			$("input[name='name1']").val(name);
			$("input[name='id1']").val(id);
			
			$("input[name='year1']").val(year);
			$("input[name='month1']").val(month);
			$("input[name='day1']").val(day);
			$("input[name='description1']").val(description);
			$("input[name='avgscore1']").val(avgscore);
			$("input[name='bc']").click(function(){
				var id=$("input[name='id']").val(); 
				var name=$("input[name='name']").val();
				var year=$("input[name='year']").val();
				var month=$("input[name='month']").val();
				var day=$("input[name='day']").val();
				var description=$("input[name='description']").val();
				var avgscore=$("input[name='avgscore']").val();
				alert(id+" "+name+" "+year+" "+month+" "+day+" "+description+" "+avgscore)
				window.location.href="UpdateStudent?id="+$("input[name='id1']").val()+"&name="+$("input[name='name1']").val()+"&year="+$("input[name='year1']").val()+"&month="+$("input[name='month1']").val()+"&day="+$("input[name='day1']").val()+"&description="+$("input[name='description1']").val()+"&avgscore="+$("input[name='avgscore1']").val();
			})
		}
	
		
</script>
</html>
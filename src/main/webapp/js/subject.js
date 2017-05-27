var pathName=window.document.location.pathname;
var path=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
$(document).ready(function(){
	$("#addSbuject").click(function(){
		$("#addSubjectModal").modal('show');
	});
	$("#subjectSubmit").click(function(){
		var subject=$("input[name='subject']").val();
		alert(subject)
		$.getJSON(path+"/subject/addSubject.do",{subject,subject},function(data){
			window.location.reload();
		});
	});
	
	$("#updateSubjectSubmit").click(function(){
		
		var id=$("input[name='subjectID']").val();
		var name=$("input[name='Subject']").val();
		$.getJSON(path+"/subject/updateSubjectById.do",{id:id,name:name},function(data){
			window.location.reload();
		})
	});
	var totalPages=$("input[name='totalPages']").val();
	var num=$("input[name='number']").val();
	var size=$("input[name='size']").val();
	var start=parseInt(num)-1;
	if(start<1){
		start=1;
	}
	var end=parseInt(num)+3;
	if(end>totalPages){
		end=totalPages;
	}
	$(".pagination").empty();
	$(".pagination").append("<li><a href='javascript:void(0)' id='prev'>&laquo;</a></li>");
	
	
	for(var i=start;i<=end;i++){
		$(".pagination").append("<li><a href="+path+"/subject/findAllSub.do?number="+(i-1)+"&&size="+size+">"+i+"</a></li>");
	}
	$(".pagination").append("<li><a href='javascript:void(0)' id='next'>&raquo;</a></li>");
	$("#prev").click(function(){
		if(num>=1){
			num=parseInt(num)-1;
			window.location.href=path+"/subject/findAllSub.do?number="+num+"&&size="+size+"";
		}
		
	});
	$("#next").click(function(){
		if(num<totalPages-1){
			num=parseInt(num)+1;
			window.location.href=path+"/subject/findAllSub.do?number="+num+"&&size="+size+"";
			}
	});
	$("##size >option").change(function(){
		var options=$(this).val();
		window.location.href=path+"/subject/findAllSub.do?number="+num+"&&size="+options+"";
		});
});
function upd(id,name){
	$("input[name='Subject']").val(name);
	$("input[name='subjectID']").val(id);
	$("#updateSubjectModal").modal('show');
}
function del(id){
	if(confirm("确认要删除？")){
		$.getJSON(path+"/subject/deleteSubjectById.do",{id:id},function(data){
			window.location.reload();
		})
		}
}
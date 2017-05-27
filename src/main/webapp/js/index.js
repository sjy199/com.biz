var pathName=window.document.location.pathname;
var path=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
$(document).ready(function(){
	$('.show-details-btn').on('click', function(e) {
		e.preventDefault();
		$(this).closest('tr').next().toggleClass('open');
		$(this).find(ace.vars['.icon']).toggleClass('fa-angle-double-down').toggleClass('fa-angle-double-up');
	});
	$("#submit").click(function(){
		var id=$("input[name='id']").val();
		var studentid=$("input[name='studentid']").val();
		var name=$("input[name='name']").val();
		var sex=$("input[name='sex']").val();
		var birthday=$("input[name='birthday']").val();
		var grade=$("input[name='grade']").val();
		if(studentid==''||name==''||birthday==''||grade==0){
			alert("信息填写不完整");
		}
		else{
			$.getJSON(path+"/student/updateStudentById.do",{id:id,studentid:studentid,name:name,sex:sex,birthday:birthday,grade:grade},function(data){
				window.location.reload();
			})
		}
			
		
	});
	$('#datetimepicker').datetimepicker({
		minView: "month",
		format: 'yyyy-mm-dd',     /*此属性是显示顺序，还有显示顺序是mm-dd-yyyy*/
		language: 'zh-CN', //汉化
		startView:"month",
	    autoclose: true
		});
	$("#subjectSubmit").click(function(){
		var options=$("#subject-select option:selected");
		var student_id=$("input[name='subjectId']").val();
		$.getJSON(path+"/addScore.do",{subject_id:options.val(),student_id:student_id},function(data){
			window.location.reload();
		});
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
		$(".pagination").append("<li><a href="+path+"/student/findAllStudent.do?number="+(i-1)+"&&size="+size+">"+i+"</a></li>");
	}
	$(".pagination").append("<li><a href='javascript:void(0)' id='next'>&raquo;</a></li>");
	$("#prev").click(function(){
		if(num>=1){
			num=parseInt(num)-1;
			window.location.href=path+"/student/findAllStudent.do?number="+num+"&&size="+size+"";
		}
		
	});
	$("#next").click(function(){
		if(num<totalPages-1){
			num=parseInt(num)+1;
			window.location.href=path+"/student/findAllStudent.do?number="+num+"&&size="+size+"";
			}
	});
$("#size >option").click(function(){
	var options=$(this).val();
	window.location.href=path+"/student/findAllStudent.do?number="+num+"&&size="+options+"";
	});
});

function edit(id){
	
	$.getJSON(path+"/student/findStudentObjectById.do",{id:id},function(data){
		$("input[name='id']").val(data.id);
		$("input[name='studentid']").val(data.studentid);
		$("input[name='name']").val(data.name);
		$("input[name='sex']").val(data.sex);
		$("input[name='birthday']").val(data.birthday);
		$("input[name='grade']").val(data.grade);
		$("#studentModal").modal("show");
	})
}

	function del(id){
		if(confirm("确认要删除？")){
		$.getJSON(path+"/student/deleteStudentById.do",{id:id},function(data){
			window.location.reload();
		})
		}
	}
	function addSubject(id){
		var subj=$("#sub_"+id+"").val();
		var subjs=new Array();
		subjs=subj.split(",");
		$.getJSON(path+"/subject/findAllSubject.do",null,function(data){
			$("#subject-select").empty();
			$("#subject-select").append("<option value='0'>点击选择课程</option>");
			$(data).each(function(index,content){
				var m=0;
				for(var i=0;i<subjs.length;i++){
					if(content.name==subjs[i]){
						m=m+1;
					}
				}
				if(m==0){
					var op="<option value='"+content.id+"'>"+content.name+"</option>";
					$("#subject-select").append(op);
				}
				
			});
			$("input[name='subjectId']").val(id);
			$("#curricula-variable-Modal").modal("show");
		});
	}
	
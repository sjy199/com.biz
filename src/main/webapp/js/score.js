var pathName=window.document.location.pathname;
var path=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
function upd(id,score){
	$("input[name='score']").val(score);
	$("input[name='scoreID']").val(id);
	$("#updateScoreModal").modal('show');
}
$(document).ready(function(){
	$("#updateScoreSubmit").click(function(){
		var score=$("input[name='score']").val();
		var id=$("input[name='scoreID']").val();
		$.getJSON(path+"/updateScoreById.do",{id:id,score:score},function(data){
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
		$(".pagination").append("<li><a href="+path+"/findAllScore.do?number="+(i-1)+"&&size="+size+">"+i+"</a></li>");
	}
	$(".pagination").append("<li><a href='javascript:void(0)' id='next'>&raquo;</a></li>");
	$("#prev").click(function(){
		if(num>=1){
			num=parseInt(num)-1;
			window.location.href=path+"/findAllScore.do?number="+num+"&&size="+size+"";
		}
		
	});
	$("#next").click(function(){
		if(num<totalPages-1){
			num=parseInt(num)+1;
			window.location.href=path+"/findAllScore.do?number="+num+"&&size="+size+"";
			}
	});
	$("#size >option").click(function(){
		var options=$(this).val();
		window.location.href=path+"/findAllScore.do?number="+num+"&&size="+options+"";
		});
});

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>글 자세히 보기</h1>
			<form action="">
				<input type="hidden" name="bno" value="${vo.bno}">
				<input type="hidden" name="curPage" value="${to.curPage}">
	            <input type="hidden" name="perPage" value="${to.perPage}">
	            <input type="hidden" name="select" value="${to.select}">
	            <input type="hidden" name="keyword" value="${to.keyword}">
			</form>
			<div class="form-group">
				<label for="bno">글번호</label>
				<input class="form-control" id="bno" value="${vo.bno}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="viewcnt">조회수</label>
				<input class="form-control" id="viewcent" value="${vo.viewcnt}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="title">제목</label>
				<input class="form-control" id="title" value="${vo.title}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input class="form-control" id="writer" value="${vo.writer}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" id="content" rows="5" readonly="readonly">${vo.content}</textarea>
			</div>
			
			<div class="form-group">
				<button id="reply_form" class="btn btn-primary">댓글</button>
				<button class="btn btn-warning modify">수정</button>
				<button class="btn btn-danger del">삭제</button>
				<button class="btn btn-infor list">목록</button>
			</div>
			<hr>
			<div class="row">
				<div id="myCollapsible" class="collapse">
					<div class="form-group">
						<label for="replyer">작성자</label>
						<input id="replyer" class="form-control">
					</div>
					<div class="form-group">
						<label for="replytext">내용</label>
						<input id="replytext" class="form-control">
					</div>
					<div class="form-group">
						<button id="replyInsertBtn" class="btn btn-default">댓글 등록</button>
						<button id="replyRestBtn" class="btn btn-default">초기화</button>
					</div>
				</div>				
			</div>
			<div id="replies" class="row">
			</div>
		</div>
	</div>
<script type="text/javascript">
	var bno = ${vo.bno};
	$(document).ready(function(){
		$("#reply_form").click(function(){
			$("#myCollapsible").collapse("toggle");
		});
		$("#replyRestBtn").click(function(){
			var replyer = $("#replyer").val("");
			var replytext = $("#replytext").val("");
		});
		$("#replyInsertBtn").click(function(){
			var replyer = $("#replyer").val();
			var replytext = $("#replytext").val();
			$.ajax({
				type : 'post',
				url : '/replies',
				headers : {
					'Content-Type' : 'application/json',
					'X-HTTP-Method-Override' : 'POST'
				},
				data : JSON.stringify({
					bno : bno,
					replyer : replyer,
					replytext : replytext
				}),
				dataType : 'text',
				success : function(result){
					if(result == 'INSERT_SUCCESS'){
						$("#replyer").val("");
						$("#replytext").val("");
						getAllList(bno);
					}
				}
			});
		});
		var $form = $("form");
		
		$(".modify").click(function(){
			$form.attr("action", "/sboard/modify");
			$form.attr("method", "get");
			$form.submit();
		});
		
		$(".del").click(function(){
			$form.attr("action", "/sboard/del");
			$form.attr("method", "post");
			$form.submit();
		});
		
		$(".list").click(function(){
			$form.attr("action", "/sboard/list");
			$form.attr("method", "get");
			$form.submit();
		});
		getAllList(bno);
	});
		function getAllList(bno){
			$.getJSON("/replies/"+bno, function(arr){
				var str = '<hr>';
				for(var i=0;i<arr.length;i++){
					str+='<div class="panel panel-info">'+
					'<div class="panel-heading">'+
					'<span>rno : '+arr[i].rno+', 작성자 : <span class="glyphicon glyphicon-user"></span>'+arr[i].replyer+'</span>'+
					'<span class="pull-right"><span class="glyphicon glyphicon-time"></span>'+arr[i].updatedate+'</span>'+
				'</div>'+
				'<div class="panel-body">'+
					'<p data-rno="'+arr[i].rno+'">'+arr[i].replytext+'</p>'+
					'<button class="btn callModal"><span class="glyphicon glyphicon-edit"></span>수정/삭제<span class="glyphicon glyphicon-trash"></span></button>'+
				'</div>'+
			'</div>';
				}
				$("#replies").html(str);
			});
		}
	
</script>
</body>
</html>
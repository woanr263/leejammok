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
<div>
	<form action="/member/insert" method="post" onsubmit="return false;">
		아이디 : <input id="id" name="id"><button>ID 중복체크</button><p id="result"></p>
		이름 : <input id="name" name="name"><br>
		나이 : <input id="age" name="age" type="number" maxlength="3"><br>
		<input id="submit" type="submit" value="확인"> &nbsp; <input type="button" onclick="location.href='/member/list'" value="취소">
	</form>
</div>

	<script type="text/javascript">
		$(document).ready(function(){
			$("button").on("click", function(event){
				event.preventDefault(); //버튼을 눌렀을때 이벤트 막는
				var id = $("input[name='id']").val();
				$.ajax({
					type : 'post',
					url : '/member/idcheck',
					data : {
						id : id
					},
					dataType : 'text',
					success : function(result){
						$('#result').text(result);
					}
				});
			});
			$("#submit").click(function(){
				var id = document.getElementById('id');
				var name = document.getElementById('name');
				var age = document.getElementById('age');
				if(!id){
					alert('아이디가 비어있습니다.');
					id.focus();
					return false;
				}else if(name.val()){
					alert('이름이 비어있습니다.');
					name.focus();
					return false;
				}else if(age.val()){
					alert('나이가 비어있습니다.');
					age.focus();
					return false;
				}
				return true;
			});
		});
	</script>
</body>
</html>
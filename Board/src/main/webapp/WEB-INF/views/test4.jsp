<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.domain.MemberVO"%>
<%@page import="java.util.List"%>
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

	<%
		List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
		ObjectMapper mapper = new ObjectMapper();
		
		String str = mapper.writeValueAsString(list);
		pageContext.setAttribute("list", str);
	%>
	<button>click</button>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("button").click(function(){
				$.ajax({
					type : 'post',
					url : '/test4',
					data : {
						list : JSON.stringify(${list})
					},
					dataType : 'text',
					success : function(result){
						var obj = JSON.parse(result);
						alert(obj[0].id);
					}
				});
			});
		});
	</script>
</body>
</html>
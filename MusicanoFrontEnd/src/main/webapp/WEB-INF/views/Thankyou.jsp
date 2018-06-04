<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank you</title>
<style>
h2{
	font-family:"Comic Sans MS", cursive, sans-serif;
	font-size:55px;
	color:Blue;
}
</style>
</head>
<body >
   <h2 align="center">Thank you</h2>
   <h4 align="center">For Shopping</h4>
   <a href="<c:url value="/"/>">
   <button type="button" align="center" class="btn btn-default">
   <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
   </button></a><br><br>
</body>
<%@include file="fot.jsp" %>
</html>
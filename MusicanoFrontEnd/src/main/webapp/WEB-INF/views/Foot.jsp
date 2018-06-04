<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC"-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type"content="text/html; charset=utf-8"/>
<title>Footer</title>
<c:url value="/Resources/Images" var="img"/>
<c:url value="/Resources/Images/instruments" var="image"/>
<c:url value="/Resources/css" var="css"/>
<c:url value="/Resources/js" var="js"/>

<link rel="stylesheet" type="text/css" href="${css}/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="${css}/stylefot.css"/>
</head>
<body>
<div class="footer-main-div">
<div class="footer-social-icons">
<ul>
<li><a href="#" target="blank"><i class="fa fa-facebook"></i></a></li>
<li><a href="#" target="blank"><i class="fa fa-twitter"></i></a></li>
<li><a href="#" target="blank"><i class="fa fa-google-plus"></i></a></li>
<li><a href="#" target="blank"><i class="fa fa-youtube"></i></a></li>
</ul>
</div>
<div class="footer-menu-one">
<ul>
<li><a href="#">Home</i></a></li>
<li><a href="#">About Us</i></a></li>
<li><a href="#">Contact Us</i></a></li>
<li><a href="#">Terms & Conditions</i></a></li>
</ul>
</div>
<div class="footer-menu-two">
<ul>
<li><a href="#">Brands</i></a></li>
<li><a href="#">Gallery</i></a></li>
<li><a href="#">Media</i></a></li>
</ul>
</div>
</div>
<div class="footer-bottom">
	<p>&#169; 2018 Copyright:Musicano.com</p>
</div>
</body>
</html>
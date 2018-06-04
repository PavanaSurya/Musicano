<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Homepage</title>
<meta charset="utf-8">
<c:url value="/Resources/Images" var="img"/>
<c:url value="/Resources/Images/instruments" var="image"/>
<c:url value="/Resources/css" var="css"/>
<c:url value="/Resources/js" var="js"/>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${css}/backgrd.css">
  
<style>

.header 
{
   background-image: url("${img}/b1460c1fc3a2553f62e5f95ab8a146c7_w.jpeg");
    padding: 20px;
}
#rcorners1 {
    border-radius: 25px;
width:100%;
height:55px;
}

ul {
    
    list-style-type: none;
    margin: 0;
    padding: 0;
    width:50px;
    
      background-color: black;
   
}

li {
    float: left; 
}

li a {
    display: block;
    font-family:Segoe Print;
    font-size: 20px;
    font-style:bold;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    transition: 0.3s;
}

.active {
    background-color: lightblack;
}

li a:hover:not(.active) {
    background-color: lightblack;
    text-decoration: none;
}
input[type=search] {
    background-image: url("${img}/search.png");
    background-repeat: no-repeat;
    background-position: 12px 17px;
    padding: 12px 20px 14px 42px; 
    border-radius:25px;
    margin-top:2px;
    outline:none;
    width: 280px;
    -webkit-transition: width 0.7s ease-in-out;
    -moz-transition: width 0.7s ease-in-out;
    -ms-transition: width 0.7s ease-in-out;
    -o-transition: width 0.7s ease-in-out;
    transition: width 0.7s ease-in-out;
    box-sizing: border-box;
    border: 2px solid #ccc;
    font-size: 16px;
    background-color: white;
    background-size: 20px;
}

input[type=text]:focus {
    width: 300px;
}



</style>

</head>
<body>
<div class="header" >
<i class="fa fa-facebook-square" style="font-size:24px"></i> 
<i class="fa fa-google-plus-square" style="font-size:24px"></i>  
<i class="fa fa-instagram" style="font-size:24px"></i>
<i class="fa fa-youtube-square" style="font-size:24px"></i>  
<i class="fa fa-volume-control-phone" style="font-size:24px;font-style:bold">Contactus:020-94847 </i>
<h5 align="right"><c1:if test="${pageContext.request.userPrincipal.name!=null}">
Welcome ${pageContext.request.userPrincipal.name}
</c1:if></h5>

</div>
<div>
<h1><a href="<c:url value="/"/>"><img src="${img}/logo.png" width="200px" height="70px"></a></h1>


</br>
</div>
<form name=frm method="post">
<ul class="tab" id="rcorners1">
<c1:if test="${pageContext.request.userPrincipal.name!=null}">
<security:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="<c:url value="/admin"/>">Admin</a></li>
</security:authorize>
</c1:if>
<li><a href="<c:url value="/shophere"/>">Shop Here</a></li>
<li><a href="<c:url value="/aboutus"/>">About Us</a></li>
&nbsp;&nbsp;&nbsp;&nbsp;
<form action="">
    <input type="search" name="" placeholder="Search....">
</form>
<!-- <li><a href="Homepage.html">Contact Us</a></li> -->
<a href="<c:url value="/Cart1"/>" style="margin-left:610px,font-size:35 color:white">
          <span class="glyphicon glyphicon-shopping-cart"></span>${items}
</a>

<c1:if test="${pageContext.request.userPrincipal.name==null}">
<li style="float:right"><a href="<c:url value="/User"/>">Login/SignUp</a></li>

</c1:if>
<c1:if test="${pageContext.request.userPrincipal.name!=null}">
<li style="float:right"><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
</c1:if>
</ul>
</form>
</body>
</html>
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
  <link rel="stylesheet" type="text/css" href="${css}/styleinst.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <style>
h5{
	font-size:15px;
	font-style:bold;
}
.header 
{
   background-image: url("${img}/b1460c1fc3a2553f62e5f95ab8a146c7_w.jpeg");
    padding: 20px;
}
#rcorners1 {
    border-radius: 25px;
width:100%;
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
input[type=text] {
    background-image: url("${img}/search.png");
    background-repeat: no-repeat;
    background-position: 12px 17px;
    padding: 12px 20px 14px 42px; 
    border-radius:25px;
    margin-top:2px;
    outline:none;
    width: 160px;
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

/* hr {  */
/*     display: block; */
/*     margin-top: 0.5em; */
/*     margin-bottom: 0.5em; */
/*     margin-left: auto; */
/*     margin-right: auto; */
/*     border-style: inset; */
/*     border-width: 1px; */
/* } */

</style>

</head>
<body>
<div class="header" >
<i class="fa fa-facebook-square" style="font-size:24px; float:left;"></i> 
<i class="fa fa-google-plus-square" style="font-size:24px; float:left;"></i>  
<i class="fa fa-instagram" style="font-size:24px; float:left;"></i>
<i class="fa fa-youtube-square" style="font-size:24px; float:left;"></i>  
<i class="fa fa-volume-control-phone" style="font-size:24px;  font-style:bold; ">Contactus:020-94847 </i>
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
<!-- <li><a href="Homepage.html">Contact Us</a></li> -->
<form action="">
    <input type="text" name="" placeholder="Search....">
</form>
<a href="<c:url value="/checkout"/>" style="margin-left:610px,font-size:35 color:white">
          <span class="glyphicon glyphicon-shopping-cart"></span>${items}
</a>


<c1:if test="${pageContext.request.userPrincipal.name==null}">
<li style="float:right"><a href="<c:url value="/User"/>">Login/SignUp</a></li>

</c1:if>
<c1:if test="${pageContext.request.userPrincipal.name!=null}">
<li style="float:right"><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
</c1:if>
</ul>

<br>
<br>
<div class="container"> 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators" style="margin-left:0px">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${image}/frame-03.jpg"  style="width:200%;">
      </div>

      <div class="item">
        <img src="${image}/frame-08.jpg"  style="width:200%;">
      </div>
    
      <div class="item">
        <img src="${image}/frame-07.jpg"  style="width:200%;">
      </div>
      
      <div class="item">
        <img src="${image}/frame-05.jpg"  style="width:200%;">
      </div>
      
      <div class="item">
        <img src="${image}/Sound system.jpg"  style="width:200%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<br>
<br>
<c1:forEach items="${products}" var="pro">
<figure class="snip1423">
 <img src="${pageContext.request.contextPath}/Resources/${pro.getImageName()}" width="250px" height="250px">
  <figcaption>
    <h3>${pro.getProName()}</h3>
    <p>${pro.getProdescrptn()}</p>
    <div class="price">
      <s> ${pro.getPrice()}</s> ${pro.getPrice()}
    </div>
  </figcaption><i class="ion-android-cart"></i>
  <a href="<c:url value="/addtocart/${pro.getProId()}"/>"></a>
</figure>
</c1:forEach><br><br>
<!-- <hr> -->
<!-- <figure class="snip1423 hover"> -->
<%-- <img src="${image}/M instruments/DHOL.jpg" alt="sample98" /> --%>
<!--   <figcaption> -->
<!--     <h3>DHOL</h3> -->
<!--     <p>Dhol can refer to any one of a number of similar types of double-headed drum widely used, with regional variations, throughout the Indian subcontinent.</p> -->
<!--     <div class="price"> -->
<!--       <s>&#8377 3,570.00</s>&#8377 1800.00 -->
<!--     </div> -->
<!--   </figcaption><i class="ion-android-cart"></i> -->
<%--   <a href="<c:url value="/Cart1"/>"></a> --%>
<!-- </figure> -->
<!-- <figure class="snip1423"> -->
<%-- <img src="${image}/M instruments/snare_drum.png" alt="sample90" /> --%>
<!--   <figcaption> -->
<!--     <h3>SNARE DRUM</h3> -->
<!--     <p>A snare drum or side drum is a percussion instrument that produces a sharp staccato sound when the head is struck with a drum stick, due to the use of a series of stiff wires held under tension against the lower skin.</p> -->
<!--     <div class="price"> -->
<!--       <s>&#8377 1800.00</s>&#8377 859.00 -->
<!--     </div> -->
<!--   </figcaption><i class="ion-android-cart"></i> -->
<%--   <a href="<c:url value="/Cart1"/>"></a> --%>
<!-- </figure> -->
</form>
<img src="${img}/83564dcae26e3f0.jpg"  style="width:100%;border-radius:25px;"><br><br>
</body>
<%@include file="fot.jsp" %>
</html>
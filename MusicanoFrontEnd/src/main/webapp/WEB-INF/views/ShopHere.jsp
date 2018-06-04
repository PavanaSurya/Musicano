<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp" %><!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<c:url value="/Resources/Images" var="img"/>
<c:url value="/Resources/Images/instruments" var="image"/>
<c:url value="/Resources/css" var="css"/>
<c:url value="/Resources/js" var="js"/>
<style>
* {
    box-sizing: border-box;
}
.content-wrapper{
	width:80%;
	margin:4% 10% 5% 10%;
}
.content-wrapper img{
	width:100%;
}
.text-wrapper{
	width:100%;
	position:relative;
	margin-top:-40%;
}
.text-wrapper h1{
	text-align:center;
	color:WHITE;
	font-size:30px;
	font-family:Segoe Print;
}
#myImg{
	border-radius:25px;
	cursor:pointer;
	transition:0.3s;
}
#myImg:hover{opacity:0.7;}
.column {
    float: left;
    width: 33.33%;
    padding: 5px;
}

/* Clearfix (clear floats) */
.row::after {
    content: "";
    clear: both;
    display: table;
}
</style>
</head>
<body>

<div class="content-wrapper">
<div class="row">

<c1:forEach items="${categories}" var="cat">

<%-- <c1:if test="${cat.getCatName()}==ElectricalInstruments"> --%>
  <div class="column">
   <a href="<c:url value="/classicalinst/${cat.getCatId()}"/>"> <img  id="myImg" src="${pageContext.request.contextPath}/Resources/${cat.getImageName()}" alt="Fjords" style="width:100%"></a>
<div class="text-wrapper"><br><br><br><br><br>
<%-- <h1>${cat.getCatName()}</h1> --%>
</div>
  </div>
<%--   </c1:if> --%>
  </c1:forEach>
<%--   <c1:forEach items="${categories}" var="cat"> --%>
<%-- <%-- <c1:if test="${cat.getCatName()}==ElectricalInstruments"> --%> 
<!--   <div class="column"> -->
<%--    <a href="<c:url value="/classicalinst"/>"> <img  id="myImg" src="${pageContext.request.contextPath}/Resources/${cat.getImageName()}" alt="Fjords" style="width:100%"></a> --%>
<!-- <div class="text-wrapper"> -->
<%-- <%-- <h1>${cat.getCatName()}</h1> --%> 
<!-- </div> -->
<!--   </div> -->
<%--   </c1:if> --%>
<%--   </c1:forEach> --%>
<%--   <c1:forEach items="${categories}" var="cat"> --%>
<!--   <div class="column"> -->
<%--     <a href="<c:url value="/instruments"/>"><img id="myImg" src="${img}/ws_Guitar_Section_1920x1080.jpg" alt="Forest" style="width:100%"></a> --%>
<!-- <div class="text-wrapper"> -->
<!-- <h1>INSTRUMENTS</h1> -->
<!-- </div> -->
<!--   </div> -->
<%--   </c1:forEach> --%>
<%--   <c1:forEach items="${categories}" var="cat"> --%>
<!--   <div class="column"> -->
<%--     <img id="myImg" src="${img}/Swietenia_macrophylla_wood.jpg" alt="Mountains" style="width:100%"> --%>
<!-- <div class="text-wrapper"> -->
<!-- <h1>EQUIPMENTS</h1> -->
<!-- </div> -->
<!--   </div> -->
<%--   </c1:forEach> --%>
</div>
</div>
</body>
<%@include file="fot.jsp" %>
</html>

<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Classical Instruments</title>
<meta charset="utf-8">
<c:url value="/Resources/Images" var="img"/>
<c:url value="/Resources/Images/instruments" var="image"/>
<c:url value="/Resources/css" var="css"/>
<c:url value="/Resources/js" var="js"/>
<link rel="stylesheet" type="text/css" href="${css}/styleinst.css">
</head>
<body>
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
</c1:forEach>
</body>
</html>
<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp" %>
<html>
<head>
<title>OrderConfirm</title>
<style>
a {
    text-decoration: none;
    display: inline-block;
    padding: 8px 16px;
    text-decoration: none;
}

a:hover {
    background-color: #ddd;
    color: black;
    text-decoration: none;
}

.previous {
	border-radius:25px;
    background-color: #f1f1f1;
    color: black;
    text-decoration: none;
}
.pay{
	border-radius:25px;
    background-color: #f1f1f1;
    color: black;
     text-decoration: none;
}
</style>
</head>
<body>

<br><br>
<table border="1px solid black">
<tr>
<th>BillingId</th>
<th>BillingName</th>
<th>Address</th>
<th>PhoneNumber</th>
<th>Country</th>
</tr>
<%-- <c1:forEach items="${billing}" var="bill"> --%>
<tr>
<td>${billing.getBillId()}</td>
<td>${billing.getBillName()}</td>
<td>${billing.getAddr()}</td>
<td>${billing.getPh_no()}</td>
<td>${billing.getCountry()}</td>
</tr>
<%-- </c1:forEach> --%>
</table>
<br><br>
<table border="1px solid black">
<tr>
<th>ShippingId</th>
<th>ShippingName</th>
<th>Address</th>
<th>PhoneNumber</th>
<th>Country</th>
</tr>
<%-- <c1:forEach items="${shipping}" var="shp"> --%>
<tr>
<td>${shipping.getShipId()}</td>
<td>${shipping.getShipName()}</td>
<td>${shipping.getAddr()}</td>
<td>${shipping.getPh_no()}</td>
<td>${shipping.getCountry()}</td>
</tr>
<%-- </c1:forEach> --%>
</table><br><br>

<table border="1px solid black">
<tr>
<th>ProductId</th>
<th>ProductImage</th>
<th>ProductName</th>
<th>Description</th>
<!-- <th>Quantity</th> -->
<th>Price</th>
<th>Actions</th>
</tr>
<c1:if test="${p!=null}">
<tr>
<td>${p.getProId()}</td>
<td><img src="${pageContext.request.contextPath}/Resources/${p.getImageName()}" width="250px" height="250px"></td>
<td>${p.getProName()}</td>
<td>${p.getProdescrptn()}</td>
<%-- <td>${p.getQty()}</td> --%>
<td>${p.getPrice()}</td>
<td><a href="<c:url value="/editProduct/${p.getProId()}"/>">Edit</a>/<a href="<c:url value="/deleteProduct/${p.getProId()}"/>">Delete</a></td>
</tr>
</c1:if>
<c1:if test="${p==null}">
<c1:forEach items="${CartItem1}" var="pro">
<tr>
<td>${pro.getProduct().getProId()}</td>
<td><img src="${pageContext.request.contextPath}/Resources/${pro.getProduct().getImageName()}" width="250px" height="250px"></td>
<td>${pro.getProduct().getProName()}</td>
<td>${pro.getProduct().getProdescrptn()}</td>
<%-- <td>${pro.getProduct().getQty()}</td> --%>
<td>${pro.getProduct().getPrice()}</td>
<td><a href="<c:url value="/editProduct/${pro.getProduct().getProId()}"/>">Edit</a>/<a href="<c:url value="/deleteProduct/${pro.getProduct().getProId()}"/>">Delete</a></td>
</tr>
</c1:forEach>
</c1:if>
</table>
<a href="<c:url value="/previous"/>" class="previous">&laquo; Previous</a>
<a href="<c:url value="/pay"/>" class="pay">pay</a>

</body>
<%@include file="fot.jsp" %>
</html>
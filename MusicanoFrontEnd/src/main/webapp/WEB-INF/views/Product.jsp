<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Product</title>
<meta charset="utf-8">
<c:url value="/Resources/Images" var="img"/>
<c:url value="/Resources/Images/instruments" var="image"/>
<c:url value="/Resources/css" var="css"/>
<c:url value="/Resources/js" var="js"/>
<link rel="stylesheet" type="text/css" href="${css}/stylepro.css">
<style>

</style>
</head>
<body>
<c:url value="/addProduct" var="pro"/>
<div class="simple-form">
<form:form action="${pro}" id="Product" method="post" commandName="product" enctype="multipart/form-data">
<form:input type="text" name="productid" id="button" placeholder="Product ID" path="proId" required="required"/><br><br>
<form:input type="text" name="productname" id="button" placeholder="Enter Product Name" path="proName" required="required"/><br><br>
<form:textarea rows="7" cols="30" name="prodec" id="button" placeholder="Enter the Product Description" path="prodescrptn" required="required"/>
<br><br>
<form:select path="category.catId">
<c1:forEach items="${categories}" var="cat">
<option value="${cat.getCatId()}" label="${cat.getCatName()}">${cat.getCatName()}</option>
</c1:forEach>
</form:select>
<form:select path="supplier.supId">
<c1:forEach items="${suppliers}" var="sup">
<option value="${sup.getSupId()}" label="${sup.getSupName()}">${sup.getSupName()}</option>
</c1:forEach>
</form:select>
<form:input type="text" name="qty" id="button" placeholder="Enter the Quantity" path="qty" required="required"/><br><br>
<form:input type="text" name="price" id="button" placeholder="Enter the Price" path="price" required="required"/><br><br>
<form:input type="file" path="pimg" name="pimg" required="required"/><br><br>
<input type="submit" value="ADD PRODUCT"  id="butt">
<input type="reset" value="CANCEL"  id="butt"><br><br>
</form:form>
</div>
<table border="1px solid black">
<tr>
<th>ProductId</th>
<th>ProductImage</th>
<th>ProductName</th>
<th>Description</th>
<th>Quantity</th>
<th>Price</th>
<th>Actions</th>
</tr>
<c1:forEach items="${products}" var="pro">
<tr>
<td>${pro.getProId()}</td>
<td><img src="${pageContext.request.contextPath}/Resources/${pro.getImageName()}" width="250px" height="250px"></td>
<td>${pro.getProName()}</td>
<td>${pro.getProdescrptn()}</td>
<td>${pro.getQty()}</td>
<td>${pro.getPrice()}</td>
<td><a href="<c:url value="/editProduct/${pro.getProId()}"/>">Edit</a>/<a href="<c:url value="/deleteProduct/${pro.getProId()}"/>">Delete</a></td>
</tr>
</c1:forEach>
</table>
</body>
<%@include file="fot.jsp" %>
</html>
<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp" %>
<html>
<head>
<title>Supplier</title>
<meta charset="utf-8">
<c:url value="/Resources/Images" var="img"/>
<c:url value="/Resources/Images/instruments" var="image"/>
<c:url value="/Resources/css" var="css"/>
<c:url value="/Resources/js" var="js"/>
<link rel="stylesheet" type="text/css" href="${css}/stylesup.css">

</head>
<body>
<c:url value="/addSupplier" var="sup"/>
<div class="simple-form">
<form:form id="Supplier" action="${sup}" method="post" commandName="supplier">
<form:input type="text" name="supid" id="button" placeholder="Supplier ID" path="supId" required="required"/><br><br>
<form:input type="text" name="supname" id="button" placeholder="Enter Supplier Name" path="supName" required="required"/><br><br>
<form:textarea rows="7" cols="30" name="addr" id="button" placeholder="Enter the Address" path="addr" required="required"/></textarea><br><br>
<select id="ph">
<option>+91</option>
<option>+81</option>
<option>+1</option>
<option>+82</option>
<option>+86</option>
<option>+41</option></select>
<form:input type="number" name="num" placeholder="Enter your Mobile Number" id="ph" path="ph_no" pattern="[7-9]{1}[0-9]{9}" maxlength="10" required="required"/><br><br>
<input type="submit" value="ADD SUPPLIER"  id="butt">
<input type="reset" value="CANCEL"  id="butt"><br><br>

</form:form>
</div>
<table border="1px solid black">
<tr>
<th>SupplierID</th>
<th>SupplierName</th>
<th>Address</th>
<th>Phone</th>
<th>Actions</th>
</tr>
<c1:forEach items="${suppliers}" var="sup">
<tr>
<td>${sup.getSupId()}</td>
<td>${sup.getSupName()}</td>
<td>${sup.getAddr()}</td>
<td>${sup.getPh_no()}</td>
<td><a href="<c:url value="/editSupplier/${sup.getSupId()}"/>">Edit</a>/<a href="<c:url value="/deleteSupplier/${sup.getSupId()}"/>">Delete</a></td>
</tr>
</c1:forEach>
</table>
<br>
<br>

</body>
<%@include file="fot.jsp" %>
</html>
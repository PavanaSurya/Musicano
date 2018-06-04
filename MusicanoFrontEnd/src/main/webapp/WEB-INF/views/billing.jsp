<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>BillingShip</title>
<meta charset="utf-8">
<c:url value="/Resources/Images" var="img"/>
<c:url value="/Resources/Images/instruments" var="image"/>
<c:url value="/Resources/css" var="css"/>
<c:url value="/Resources/js" var="js"/>
<link rel="stylesheet" type="text/css" href="${css}/stylebilshp.css">
<style>
body{
	background-image:url("${img}/161730882.jpg");
	background-repeat:no-repeat;
	background-size:100% 900px;
}
</style>
</head>
<body>
<div class="simple-form">
<form id="Billship">
<div class="row">
          <div class="col-50">
<h3>BILLING</h3>
<form:input type="text" hidden="hidden" name="billid" id="button" placeholder="Billing ID" path="billing.billId"/><br><br>
<form:input type="text" name="billname" id="button" placeholder="Enter Billing Name" path="billing.billName"/> <br><br>
<form:textarea rows="7" cols="30" name="addr" id="button" placeholder="Enter the Address" path="billing.addr"/></textarea><br><br>
<select id="ph">
<option>+91</option>
<option>+86</option>
<option>+1</option>
<option>+82</option>
<option>+81</option>
</select>
<form:input type="number" name="num" placeholder="Enter your Mobile Number" id="ph" path="billing.ph_no"/><br><br>
<form:input type="text" name="country" id="button" placeholder="Enter Country Name" path="billing.country"/> <br><br>
</div>
</div>
</form>

<c:url value="/orderConfirm" var="con"/>
<form:form action="${con}" method="post" commandName="shipping" id="Billship">
<div class="col-50">

<h3>SHIPPING</h3>

<form:input type="text" hidden="hidden" name="shipid" id="button" placeholder="Shipping ID" path="shipId" required="required"/><br><br>
<form:input type="text" name="shipname" id="button" placeholder="Enter the Shipping Name" path="shipName" required="required"/><br><br>
<form:textarea rows="7" cols="30" name="addr" id="button" placeholder="Enter the Address" path="addr" required="required"/></textarea><br><br>
<select id="ph">
<option>+91</option>
<option>+86</option>
<option>+1</option>
<option>+82</option>
<option>+81</option>
</select>
<form:input type="text" id="button" placeholder="PhoneNumber" path="ph_no" pattern="[7-9]{1}[0-9]{9}" maxlength="10" required="required"/><br><br>
<form:input type="text" name="country" id="button" placeholder="Enter Country Name" path="country" required="required"/><br><br>
</div>
<input type="submit" value="CONTINUE"  id="butt">
</form:form>

</div>
</div>
</body>
<%@include file="fot.jsp" %>
</html>
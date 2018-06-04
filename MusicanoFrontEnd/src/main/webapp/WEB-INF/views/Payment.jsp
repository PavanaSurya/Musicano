<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Payment</title>
<style>
body{
/* /* 	background-image: url("${img}/146126092.jpg"); */ */
/* 	background-size:cover; */
    	background-position: center;
}
</style>
<meta charset="utf-8">
<c:url value="/Resources/Images" var="img"/>
<c:url value="/Resources/Images/instruments" var="image"/>
<c:url value="/Resources/css" var="css"/>
<c:url value="/Resources/js" var="js"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${css}/stylepay.css">
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script>
var app=angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http){
	$http.get("http://localhost:8080/MusicanoFrontEnd/SendMail")
	});
</script>
</head>
<body>
<div class="simple-form">
<c:url value="/payment" var="pay"/>
<form:form id="Payment" action="${pay}" method="post">
	<h2>PAYMENT</h2>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div><br><br>
            <input type="text" name="cardname" id="button" placeholder="Enter Card Name" required="required"><br><br>
  	<input type="text" name="cardnum" id="button" placeholder="Enter Card Number" required="required"><br><br>
            <input type="text" name="expmonth" id="button" placeholder="Exp Month" required="required"><br><br>
            <div class="row">
              <div class="col-50">
	   <input type="text" name="expyear" id="button" placeholder="Exp Year" required="required">
              </div><br>
              <div class="col-50">
	   <input type="text" name="cvv" id="button" placeholder="CVV" required="required">
              </div><br>
            </div>
            <input type="text" name="otp" ng-app="myApp" ng-controller="myCtrl" id="button" placeholder="OTP" required="required"><br><br>
	<a href="<c:url value="/thankyou"/>"><input type="submit" value="PAY"  id="butt" ></a><br><br>
</form:form>
</body>
<%@include file="fot.jsp" %>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Musicano::Cart</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.button4 {border-radius: 12px;}
</style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                <c1:forEach items="${cartItems}" var="ci">
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> 
                            <img class="media-object" src="${pageContext.request.contextPath}/Resources/${ci.getProduct().getImageName()}" width="250px" height="250px"></a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${ci.getProduct().getProName()}</a></h4>
<!--                                 <h5 class="media-heading"> by <a href="#">Brand name</a></h5> -->
                                <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input type="text" class="form-control" id="exampleInputEmail1" value="1" required="required">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${ci.getProduct().getPrice()}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${ci.getProduct().getPrice()}</strong></td>
                        <td class="col-sm-1 col-md-1">
                        <a href="<c:url value="/Buy/${ci.getProduct().getProId()}/${ci.getCartItems_Id()}"/>"><button class="button button4">BUY</button></a>
                        <a href="<c:url value="/Remove/${ci.getCartItems_Id()}"/>">
                        <button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove" ></span> Remove
                        </button></td></a>
                    </tr>
                    </c1:forEach>
                    
                    
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong>${Grandtotal}</strong></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a href="<c:url value="/Buyall"/>" class="btn btn-info btn-lg">
                      <span class="glyphicon glyphicon-ok-circle"></span>BUY ALL</a>
                        </button>
                        </td>
                        <td>
                        <a href="<c:url value="/RemoveAll"/>" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-remove-circle"></span> REMOVE ALL</a>
                        </td>
                    </tr>
                   <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a href="<c:url value="/"/>">
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </button></td></a>
<!--                         <td> -->
<!--                         <button type="button" class="btn btn-success"> -->
<!--                             Checkout <span class="glyphicon glyphicon-play"></span> -->
<!--                         </button></td> -->
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<%@include file="fot.jsp" %>
</html>
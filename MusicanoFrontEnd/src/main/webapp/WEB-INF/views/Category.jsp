<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="Header.jsp" %>
<html>
<head>
<title>Category</title>
<meta charset="utf-8">
<c:url value="/Resources/Images" var="img"/>
<c:url value="/Resources/Images/instruments" var="image"/>
<c:url value="/Resources/css" var="css"/>
<c:url value="/Resources/js" var="js"/>
<link rel="stylesheet" type="text/css" href="${css}/stylecat.css">
</head>
<body>
<c:url value="/addCategory" var="cat"/>
<div class="simple-form">
<form:form id="Category" action="${cat}" method="post" commandName="category" enctype="multipart/form-data">
<form:input type="text" name="catid" id="button" placeholder="Category ID" path="catId" required="required"/><br><br>
<form:input type="text" name="catname" id="button" placeholder="Enter Category Name" path="catName" required="required"/><br><br>
<form:input type="file" path="pimg" name="pimg"/><br><br>
<input type="submit" value="ADD CATEGORY"  id="butt">
<input type="reset" value="CANCEL"  id="butt"><br><br>
</form:form>
</div>

<table border="1px solid black">
<tr>
<th>CategoryId</th>
<th>CategoryName</th>
<th>CategoryImage</th>
<th>Actions</th>
</tr>
<c1:forEach items="${categories}" var="cat">
<tr>
<td>${cat.getCatId()}</td>
<td>${cat.getCatName()}</td>
<td><img src="${pageContext.request.contextPath}/Resources/${cat.getImageName()}" width="250px" height="250px"></td>
<td><a href="<c:url value="/editCategory/${cat.getCatId()}"/>">Edit</a>/<a href="<c:url value="/deleteCategory/${cat.getCatId()}"/>">Delete</a></td>
</tr>
</c1:forEach>
</table>

</body>
<%@include file="fot.jsp" %>
</html>
<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>User</title>
</head>
<form>
<fieldset>
<legend>User Form:</legend>
<label>User ID:</label>
<input type="text" name="userid">
<br>
<br>
<label>User Name:</label>
<input type="text" name="username">
<br>
<br>
<label>Address:</label>
<textarea rows="10" cols="40">
</textarea>
<br>
<br>
<label>Phone:</label>
<input type="tel" name="tel">
<br>
<br>
<label>Email Id:</label>
<input type="email" name="email">
<br>
<br>
<label>Password:</label>
<input type="text" name="password">
<br>
<br>
<input type="submit" value="Register">
<input type="reset" value="Cancel">
</fieldset>
</form>
<%@include file="fot.jsp" %>
</html>
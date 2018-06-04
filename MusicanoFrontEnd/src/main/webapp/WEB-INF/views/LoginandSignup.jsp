<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
 <head>
 <c:url value="/Resources/Images" var="img"/>
<c:url value="/Resources/Images/instruments" var="image"/>
<c:url value="/Resources/css" var="css"/>
<c:url value="/Resources/js" var="js"/>
        <link href="${css}/Main.css" rel="stylesheet"/>
       <script src="${js}/jquery-1.10.2.min.js"></script>
       <script src="${js}/JQUERY%20Main.js"></script>
       <%@include file="Header.jsp" %>
    </head>
    
    <body>
        <div id="box" style="margin-top:150px;">
       <div id="main"></div>          
            <div id="loginform">
            <h1>LOGIN</h1>
            <c:url value="/j_spring_security_check" var="login"/>
            <form:form action="${login}" method="post">
             <input type="email" placeholder="Email" name="j_username" required="required"/><br>
                <input type="password" placeholder="Password" name="j_password" required="required"/><br>
            <button>LOGIN</button>
            <button>Cancel</button> 
            </form:form>
          </div> 
            <div id="signupform">
               <h1>SIGN UP</h1>
               <c:url value="/addUser" var="users"/>
               <form:form action="${users}" method="post" commandName="user">
               <form:input type="text" placeholder="User ID" path="userId" /><br>
               <form:input type="text" placeholder="User Name" path="userName" required="required"/><br>     
       		   <form:input type="text" placeholder="Address" path="addr" required="required"/><br>
			   <form:input type="text" placeholder="PhoneNumber" path="ph_no" pattern="[7-9]{1}[0-9]{9}" maxlength="10" required="required"/><br>
			   <form:input type="email" placeholder="EmailID" path="email_Id" required="required"/><br>
			   <form:input type="password" placeholder="Password" path="pwd" min="6" max="10" required="required"/><br>
			   <form:input type="text" placeholder="Billing ID" path="billing.billId" /><br>
			   <form:input type="text" placeholder="Billing Name" path="billing.billName" required="required"/><br>
			   <form:input type="text" placeholder="Country" path="billing.country" required="required"/><br>
        		<button>Register</button>
   				 <button>Cancel</button> 
    			</form:form>
      </div>
     <div id="login_msg">Have an account?</div>
      <div id="signup_msg">Don't have an account?</div>        
            <button id="login_btn">LOGIN</button>
        <button id="signup_btn">SIGN UP</button>  
        </div>

 </body><br>
<%--  <%@include file="fot.jsp" %> --%>
</html>
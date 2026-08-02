<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<body>

	<form action="login" method="get">

		Username: <input type="text" name="username"> <br> <br>
		Password: <input type="password" name="password"> <br> <br>
		<input type="submit" value="Login"> <span> 
		<%
         String errmsg = (String) session.getAttribute("errmsg");
        %> 
        
        <%=errmsg == null ? "" : errmsg%>
		</span>

	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<style>
div {
  background-color: lightblue;
  color: navy;
  font-size: 16px;
  border: 2px solid blue;
  padding: 5px;
  margin: 10px;
}
</style>
</head>
<body>

<div align="center">
<h1>Create Your Account</h1>

<form action="SignUpServlet" method="post">
<table>
<tr><td>Enter Name: <input type="text" name="txtName"></td></tr> 
<tr><td>Enter Password: <input type="password" name="txtPwd"></td></tr>
<tr><td>Enter Mail: <input type="text" name="mail"></td></tr>
<tr><td><input type="submit" value="Register"><input type="reset" value="clear"></td></tr> 
<tr><td><h3>Already have an account? <a href="login.jsp"> Login</a></h3></td></tr>

</table>
</form>
</div>
</body>
</html>
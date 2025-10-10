<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
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
<h1>Login Your Account</h1>

<form action="LoginServlet" method="post">
<table>
<tr><td>Enter Name: <input type="text" name="txtName"></td></tr> 
<tr><td>Enter Password: <input type="password" name="txtPwd"></td></tr>
<tr><td><input type="submit" value=Login><input type="reset" value="clear"></td><td><a href="#">Forget?</a></td></tr> 
<tr><td><h3>Create a new account? <a href="siginup.jsp"> SignUP</a></h3></td></tr>

</table>
</form>
</div>
</body>
</html>
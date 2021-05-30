<%-- 
    Document   : login
    Created on : May 27, 2021, 4:38:41 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <form action="Login.do" method="POST">
            <h2>Username</h2>
            <input type="text" name = "username" required/>
            <br>
            
            <h2></h2>
            <input type="password" name="password" required />
            
            <br>
            <br>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>

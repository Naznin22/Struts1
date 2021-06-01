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
        <h1>Add Form</h1>
        <form action="home.do" method="POST">
            <h2>ID</h2>
            <input type="text" name = "user_id" required/>
            <br>
            
            <h2>User Name</h2>
            <input type="text" name="name" required />
            
            <br>
            <br>
            <h2>Role</h2>
            <input type="text" name="role" required />
            <br>
            <br>
            
            
            <input type="submit" value="Add" />
        </form>
    </body>
</html>

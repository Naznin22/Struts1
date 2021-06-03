<%-- 
    Document   : success
    Created on : May 27, 2021, 4:38:55 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success Page</title>
    </head>
    <body>
        <h1>Login successful!!!</h1>
        <br>
        <br>
        
        <form action="Logout.do" method="POST">
            <input type="submit" value="Logout" />
        </form>
        <br> 
        
        <!-- .do must be given in action  -->
        <form action="/StrutsPractice1/home.do" method="POST">
            <input type="submit" value="home" />
        </form>
        
    </body>
</html>

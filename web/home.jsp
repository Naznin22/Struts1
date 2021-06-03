<%-- 
    Document   : login
    Created on : May 27, 2021, 4:38:41 PM
    Author     : User
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
        <script type="text/javascript">
            function edit() {
                let e = document.EditUserFormBean;
                e.action = "/StrutsPractice1/editUser.do";
                e.submit();
            }
            
        </script>
    </head>
    <body>
        <h1>Add User</h1>
        <form action="/StrutsPractice1/homeSubmit.do" method="POST">
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
            
            
            <input type="submit" value="Add User" />
        </form>
        <br>
        
     
            <TABLE>
            <% 
                if (session.getAttribute("users") != null) {
                List users = (List) session.getAttribute("users");
                %>
                <h3>
                <% out.print("users: " + users.size()); %>
                </h3>
                <%
                for(int row=0; row < users.size(); row++) { %>
                <TR>
                    <TD>
                        <%= users.get(row) %>
                    </TD>
                    <TD>
                        <input type="button" value="Edit" onclick="edit()" />
                    </TD>
                    <TD>
                        <input type="button" value="Delete" onclick="delete()" />
                    </TD>
                </TR>
            <% } 
            }%>
        </TABLE>
        
    </body>
</html>

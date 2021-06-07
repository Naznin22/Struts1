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
        <title>Login Page</title>
        <script type="text/javascript">
            function login() {
                let f = document.loginFormBean;
                f.action = "/StrutsPractice1/loginSubmit.do";
                f.submit();
            }
        </script>
    </head>
    <body>

        <html:form action="/login">
            <h1>Login Form</h1>
            <div style="padding:16px">
            <%
                if (session.getAttribute("errors") != null) {
                    List errors = (List) session.getAttribute("errors");
                    for (int i = 0; i < errors.size(); i++) {
            %>
            </div>
            <br>
            <div style="padding:16px">
                <%
                    out.print(errors.get(i));
                %>
            </div>

            <% }
                }
            %>
            <h2>Username</h2>
            <input type="text" name="username" />
            <br>
            <h2>Password</h2>
            <input type="password" name="password"  />
            <p></p>
            <input type="button" value="Login" onclick="login()" />
        </html:form>

    </body>
</html>

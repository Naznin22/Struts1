<%-- 
    Document   : login
    Created on : May 27, 2021, 4:38:41 PM
    Author     : User
--%>

<%@page import="java.util.ArrayList"%>
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
                function edit(id, name, role) {
                let ele_id = document.getElementById("user_id");
                ele_id.setAttribute("value",id);
                let ele_name = document.getElementById("name");
                ele_name.setAttribute("value", name);
                let ele_role = document.getElementById("role");
                ele_role.setAttribute("value", role);
//                h.action = "/StrutsPractice1/home.do";
//                h.submit();
            }
            function insert(){ 
                let h  = document.homeFormBean;
                h.action = "/StrutsPractice1/homeSubmit.do";
                h.submit();
            }
            function update(){
                let h  = document.homeFormBean;
                h.action = "/StrutsPractice1/homeUpdate.do";
                h.submit();
            }
            
            function del(id){
                let h  = document.homeFormBean;
                h.user_id.value = id;
                h.action = "/StrutsPractice1/homeDelete.do";
                h.submit();
            }
          
        </script>
    </head>
    <body>
        <h1>Add User</h1>
        <html:form >
            <h2>ID</h2>
            <input type="text" id="user_id" name = "user_id"  required/>
            <br>
            
            <h2>User Name</h2>
            <input type="text" id="name" name="name"  required />
            
            <br>
            <br>
            <h2>Role</h2>
            <input type="text" id= "role" name="role"   required />
            <br>
            <br>
            
            <input type="submit" value="Add User" onclick = "insert()"/>
            <input type="submit" value="Modify" onclick="update()" />
      
        <br>
        
     
            <TABLE>
            <% 
                if (session.getAttribute("users") != null) {
                ArrayList <List <String> > users = (ArrayList <List <String> >) session.getAttribute("users");
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
                        <input type="button" value="Edit" onclick=
                               <% 
                                   String id_str =  users.get(row).get(0);
                                   int id = Integer.valueOf(id_str);
                                   String name = users.get(row).get(1);
                                   String role = users.get(row).get(2);
                               %>
                            "edit(<%= id %>, '<%= name %>' , '<%= role %>') "
                            />
                    </TD>
                    <TD>
                        <input type="button" value="Delete" onclick=
                            "del(<%= id %>) "
                             />
                    </TD>
                </TR>
            <% } 
            }%>
        </TABLE>
         </html:form>
    </body>
</html>

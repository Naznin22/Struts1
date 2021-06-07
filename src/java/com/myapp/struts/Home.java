/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import com.myapp.struts.dao.DAO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author User
 */
public class Home extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String HOME = "home";
    
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String actionPath = "";
        DAO dao = new DAO();
        HomeFormBean homeFormBean = (HomeFormBean) form;
        
        if (mapping.getPath().equals("/home")) {
            ArrayList <List <String> > users = dao.getData("select * from demo_users order by user_id");
            request.getSession().setAttribute("users", users);
            actionPath = HOME;
        } 
        
        else if (mapping.getPath().equals("/homeUpdate")) {
            int id = homeFormBean.getUser_id();
            String name = homeFormBean.getName();
            String role = homeFormBean.getRole();
            
            String check_query = "select * from demo_users where user_id = "+ id;
           
            ArrayList <List <String> > user = dao.getData(check_query);
            System.out.println(user);
            if(user.size() > 0){
                String update_query = "update demo_users set role = '" + role + "', name = '"+ name + "' where user_id = " + id;
                System.out.println(update_query);
                dao.updateData(update_query);
                
            }
            ArrayList <List<String> > users = dao.getData("select * from demo_users order by user_id");
            request.getSession().setAttribute("users", users);
            actionPath = HOME;
        } 
        
        else if (mapping.getPath().equals("/homeDelete")) {
            int id = homeFormBean.getUser_id();
            System.out.println("id = " + id);
            
            String check_query = "select * from demo_users where user_id = "+ id;
           
            ArrayList <List <String> > user = dao.getData(check_query);
            System.out.println(user);
            if(user.size() > 0){
                String delete_query =  "delete from demo_users where user_id = " + id;
                System.out.println(delete_query);
                dao.deleteData(delete_query);
                
            }
            ArrayList <List<String> > users = dao.getData("select * from demo_users order by user_id");
            request.getSession().setAttribute("users", users);
            actionPath = HOME;
        } 
    
        else if (mapping.getPath().equals("/homeSubmit")) {
            
            int id = homeFormBean.getUser_id();
            String name = homeFormBean.getName();
            String role = homeFormBean.getRole();
            
            
            
            String query = " INSERT INTO demo_users (user_id, name, role) VALUES (" + id + " ,'"+name+ "', '" + role +"' )";
            System.out.println(query);
            dao.insertData(query);

            ArrayList <List<String> > users = dao.getData("select * from demo_users order by user_id");
            request.getSession().setAttribute("users", users);
             
            actionPath = HOME;
        }
        return mapping.findForward(actionPath);
        
    }
}

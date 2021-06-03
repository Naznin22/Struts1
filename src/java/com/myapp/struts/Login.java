/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import com.myapp.struts.dao.DAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author User
 */
public class Login extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String WELCOME = "Welcome";

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
        
        LoginFormBean loginFormBean = (LoginFormBean) form;
        
        String actionPath = "";
        
        List<String> errors = new ArrayList();
        
        if (mapping.getPath().equals("/login")) {
            System.out.print(loginFormBean);
            request.getSession().setAttribute("errors", null);
            actionPath = SUCCESS;
        } 
        else if (mapping.getPath().equals("/loginSubmit")) {
            
            if (loginFormBean.getUsername() == null || loginFormBean.getUsername().length() < 1) {
                errors.add("Username required");
            }
            if (loginFormBean.getPassword() == null || loginFormBean.getPassword().length() < 1) {
                errors.add("password required");
            }
            if (loginFormBean.getPassword().length() < 4 && loginFormBean.getPassword().length() >= 1) {
                errors.add("password minlength should be atleast 4");
            }

            System.out.println("errors: " + errors);
            request.getSession().setAttribute("errors", errors);

            String username = loginFormBean.getUsername();
            String password = loginFormBean.getPassword();
            String query = "select user_id, name, role from demo_users where name='" + username + "'and password='" + password + "'";
            System.out.println(query);

            DAO dao = new DAO();
            List data = dao.getData(query);
            
            if (data.size() > 0) {
                actionPath = SUCCESS;
            } else {
                actionPath = FAILURE;
            }            
        }
        
        return mapping.findForward(actionPath);
    }

}

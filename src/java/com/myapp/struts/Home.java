/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import com.myapp.struts.dao.DAO;
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
    private static final String DATAFORM = "dataform";

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
        
        HomeFormBean hfb = (HomeFormBean) form;
        int id = hfb.getUser_id();
        String name = hfb.getName();
        String role = hfb.getRole();
        
        DAO dao = new DAO();
        String query = " INSERT INTO demo_users (user_id, name, role) VALUES (" + id + " ,'"+name+ "', '" + role +"' )";
        System.out.println(query);
        dao.insertData(query);
        return mapping.findForward(DATAFORM);
    }
}

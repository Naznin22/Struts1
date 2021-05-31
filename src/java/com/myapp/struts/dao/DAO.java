/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DAO {
    
    public List getData(String name, int dept_no) throws Exception {
        List <String> job_list = new ArrayList();
        
        String query = "SELECT * from EMP";
        System.out.println("jdbc connection");
        Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.11.201.251:1521:stlbas", "HR", "HR")) {
                try {
                    
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    System.out.println("SQL statement is executed!" );
                    
                    while(rs.next()){
                        String result = rs.getString("JOB");
                        System.out.println(result);
                        job_list.add(result);
                    }
                    
                } catch (SQLException ex) {
                    System.out.println("SQL statement is not executed!" + ex);
                }
                
        
        }
        return job_list;
        
    }
}

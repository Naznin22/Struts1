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
    
    public List<String> getData(String query) throws Exception {
        List<String> job_list = new ArrayList<String>();
        ResultSet rs;
        
        System.out.println("jdbc connection");
        Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.11.201.251:1521:stlbas", "HR", "HR")) {
                try {
                    
                    Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    System.out.println("SQL statement is executed!"+rs );
                    
                    if(rs.next()){
                        System.out.println(rs.getString("name"));
                        int id = rs.getInt("user_id");
                        String name = rs.getString("name");
                        String role = rs.getString("role");
                        System.out.println(id+ " "+name+" "+role);
                        job_list.add(name);
                        job_list.add(role);
                    }
                    
                } catch (SQLException ex) {
                    System.out.println("SQL statement is not executed!" + ex);
                }
                
        con.close();
        }
        return job_list;
            
    }
    
    public void insertData(String query) throws Exception{
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
                        
                    }
                    
                } catch (SQLException ex) {
                    System.out.println("SQL statement is not executed!" + ex);
                }
                
        
        }
    }
    
}


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
    
    public ArrayList<List<String>> getData(String query) throws Exception {
        ArrayList <List<String>> job_list = new ArrayList<List<String>>();
        
        ResultSet rs;
        
        System.out.println("jdbc connection");
        Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.11.201.251:1521:stlbas", "HR", "HR")) {
                try {
                    
                    Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    System.out.println("SQL statement is executed!"+rs );
                    
                    while(rs.next()){
                        System.out.println(rs.getString("name"));
                        String id = Integer.toString(rs.getInt("user_id"));
                        String name = rs.getString("name");
                        String role = rs.getString("role");
                        System.out.println(id+ " "+name+" "+role);
                        List<String> job = new ArrayList();
                        job.add(id);
                        job.add(name);
                        job.add(role);
                        System.out.println("job "+job);
                        job_list.add(job);
                        System.out.println("job_list "+job_list);
                    }
                    
                    
                } catch (SQLException ex) {
                    System.out.println("SQL statement is not executed in getData function!" + ex);
                }
                
        con.close();
        }
        return job_list;
            
    }
    
    public void insertData(String query) throws Exception{
        System.out.println("insertData called");
        Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.11.201.251:1521:stlbas", "HR", "HR")) {
                try {
                    
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    System.out.println("insert data statement is executed!" );
                    
                } catch (SQLException ex) {
                    System.out.println("SQL statement is not executed in insertData function!" + ex);
                }
                
        
        }
    }
    
        public void updateData(String query) throws Exception{
        System.out.println("updateData called");
        Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.11.201.251:1521:stlbas", "HR", "HR")) {
                try {
                    
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    System.out.println("update data statement is executed!" );
                  
                } catch (SQLException ex) {
                    System.out.println("SQL statement is not executed in updateData function!" + ex);
                }
                
        
        }
    }
        
        public void deleteData(String query) throws Exception{
        System.out.println("deleteData called");
        Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.11.201.251:1521:stlbas", "HR", "HR")) {
                try {
                    
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    System.out.println("delete data statement is executed!" );
                  
                } catch (SQLException ex) {
                    System.out.println("SQL statement is not executed in deleteData function!" + ex);
                }
                
        
        }
    }
    
}


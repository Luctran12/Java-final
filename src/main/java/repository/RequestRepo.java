/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jdbc.JDBCUtil;
import model.ITRequest;

/**
 *
 * @author LENOVO
 */
public class RequestRepo {
    public void addRequest(ITRequest req) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String query = "INSERT INTO ITRequest (ReqName, ReqDate, ReqEmail, ReqType, ReqDetails)\n" +"VALUES (?,?,?,?,?);";
        
        
        try{
             PreparedStatement ps = conn.prepareStatement(query);
             
             ps.setString(1, req.getName());
             ps.setDate(2, req.getDate());
             ps.setString(3, req.getEmail());
             ps.setString(4,req.getType());
             ps.setString(5,req.getDetail());
             
              int affectedRows = ps.executeUpdate();
              System.out.println("Affected: " + affectedRows);
         }catch(SQLException e) {
             System.out.println("loi roi em oi");
         }
         
         conn.close();
    }
    
    public ITRequest findById(String id) throws SQLException{
        Connection conn = JDBCUtil.getConnection();
        String query = "SELECT * from ITRequest WHERE ReqID = "+id;
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        ITRequest res = new ITRequest();
        
        while(rs.next()) {
             
             res.setId(rs.getInt(1));
             res.setName(rs.getString(2));
             res.setDate(rs.getDate(3));
             res.setEmail(rs.getString(4));
             res.setType(rs.getString(5));
             res.setDetail(rs.getString(6));
             
        }
        
        return res;
                
    }
}

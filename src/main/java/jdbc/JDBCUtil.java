/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LENOVO
 */
public class JDBCUtil {
    public static String url = "jdbc:mysql://localhost:3306/VBoxData";
    public static String username = "root";
    public static String password = "admin";
    
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}

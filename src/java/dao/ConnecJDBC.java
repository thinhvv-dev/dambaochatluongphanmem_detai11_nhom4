/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenDinhTien
 */
public class ConnecJDBC {
    static Connection conn = null;
    public static Connection getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnecJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbclpm?useSSL=false","root","Tjeens");
        } catch (SQLException ex) {
            Logger.getLogger(ConnecJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}

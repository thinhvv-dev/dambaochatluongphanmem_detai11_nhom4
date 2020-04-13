/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BankAccountDTO;
import model.SavingDTO;

/**
 *
 * @author NguyenDinhTien
 */
public class TaikhoanDAO {
    public static BankAccountDTO getSaving(String numberSaving, String idCard) {
        BankAccountDTO savingDTO = new BankAccountDTO();
        String sql = "select * from bankaccount where banknumber = '"+numberSaving+"' and idcard = '"+idCard+"'";
        Connection conn = ConnecJDBC.getConn();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                savingDTO.setId(Integer.parseInt(resultSet.getString(1)));
                savingDTO.setFullName(resultSet.getString(4));
                savingDTO.setAddress(resultSet.getString(5));
                savingDTO.setPhone(resultSet.getString(6));
                savingDTO.setEmail(resultSet.getString(7));
                savingDTO.setIdcard(resultSet.getString(2));
                savingDTO.setAccountBalance(new BigDecimal(resultSet.getString(8)));
                savingDTO.setStatus(resultSet.getString(9));
                savingDTO.setBanknumber(resultSet.getString(3));
            }
            statement.close();
            resultSet.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(WithdrawBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return savingDTO;
    }
    public static int naptien(String numberSaving, String sotien) {
        BankAccountDTO savingDTO = new BankAccountDTO();
        String sql = "update bankaccount set accountbalance = accountbalance + "+sotien+" where banknumber = '"+numberSaving+"'";
        Connection conn = ConnecJDBC.getConn();
        int result = 0;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            result = statement.executeUpdate();
            conn.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaikhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int moso(String numberSaving, String sotien) {
        
        String sql = "update bankaccount set accountbalance = accountbalance - "+sotien+" where banknumber = '"+numberSaving+"'";
        Connection conn = ConnecJDBC.getConn();
        int result = 0;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            result = statement.executeUpdate();
            conn.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaikhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int rutso(String numberSaving, String sotien) {
        
        String sql = "update bankaccount set accountbalance = accountbalance + "+sotien+" where banknumber = '"+numberSaving+"'";
        Connection conn = ConnecJDBC.getConn();
        int result = 0;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            result = statement.executeUpdate();
            conn.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaikhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}

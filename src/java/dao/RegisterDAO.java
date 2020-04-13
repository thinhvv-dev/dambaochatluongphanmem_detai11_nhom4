/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BankAccountDTO;

/**
 *
 * @author NguyenDinhTien
 */
public class RegisterDAO extends ConnecJDBC{
    public static void insertBankAccount(BankAccountDTO bankAccountDTO, int id){
        Connection conn = ConnecJDBC.getConn();
        String sql = "insert into bankaccount(fullname,address,phone,email,idcard,banknumber,accountbalance,status,created)values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prestm = conn.prepareStatement(sql);
            prestm.setString(1, bankAccountDTO.getFullName());
            prestm.setString(2, bankAccountDTO.getAddress());
            prestm.setString(3, bankAccountDTO.getPhone());
            prestm.setString(4, bankAccountDTO.getEmail());
            prestm.setString(5, bankAccountDTO.getIdcard());
            prestm.setString(6, bankAccountDTO.getBanknumber());
            prestm.setBigDecimal(7, bankAccountDTO.getAccountBalance());
            prestm.setString(8, bankAccountDTO.getStatus());
            prestm.setString(9, id+"");
            prestm.executeUpdate();
            conn.close();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

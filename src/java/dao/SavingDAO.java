/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SavingDTO;

/**
 *
 * @author NguyenDinhTien
 */
public class SavingDAO extends ConnecJDBC {

    public static void insertSaving(SavingDTO t) {
        Connection conn = ConnecJDBC.getConn();
        String sql = "insert into saving(fullname,\n"
                + "  address,\n"
                + "  phone,\n"
                + "  email,\n"
                + "  idcard,\n"
                + "  issueby,\n"
                + "  desposite,\n"
                + "  currency,\n"
                + "  period,\n"
                + "  paymentmethot,\n"
                + "  interestrate,\n"
                + "  fromdate,\n"
                + "  numbersaving,\n"
                + "  updatedate,\n"
                + "  insertby,\n"
                + "  status,\n"
                + "  todate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prestm = conn.prepareStatement(sql);
            prestm.setString(1, t.getFullName());
            prestm.setString(2, t.getAddress());
            prestm.setString(3, t.getPhone());
            prestm.setString(4, t.getEmail());
            prestm.setString(5, t.getIdCard());
            prestm.setString(6, t.getIssueBy());
            prestm.setBigDecimal(7, t.getDesposite());
            prestm.setString(8, t.getCurrency());
            prestm.setInt(9, t.getPeriod());
            prestm.setString(10, t.getPaymentMethot());
            prestm.setFloat(11, t.getInterestRate());
            prestm.setString(12, t.getFromDate());
            prestm.setString(13, t.getNumberSaving());
            prestm.setString(14, t.getUpdateDate());
            prestm.setString(15, t.getInsertBy());
            prestm.setString(16, t.getStatus());
            prestm.setString(17, t.getToDate());
            prestm.executeUpdate();
            conn.close();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(SavingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

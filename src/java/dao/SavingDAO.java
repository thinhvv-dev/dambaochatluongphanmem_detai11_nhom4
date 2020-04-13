/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BankAccountDTO;
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

    public static List<SavingDTO> getList(String numberBank) {
        List<SavingDTO> list = new ArrayList<>();
        String sql = "select * from saving where insertby = '" + numberBank + "'";
        Connection conn = ConnecJDBC.getConn();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                SavingDTO savingDTO = new SavingDTO();
                savingDTO.setId(Long.parseLong(resultSet.getString(1)));
                savingDTO.setFullName(resultSet.getString(2));
                savingDTO.setAddress(resultSet.getString(3));
                savingDTO.setPhone(resultSet.getString(4));
                savingDTO.setEmail(resultSet.getString(5));
                savingDTO.setIdCard(resultSet.getString(6));
                savingDTO.setIssueBy(resultSet.getString(7));
                savingDTO.setDesposite(new BigDecimal(resultSet.getString(8)));
                savingDTO.setCurrency(resultSet.getString(9));
                savingDTO.setPeriod(Integer.parseInt(resultSet.getString(10)));
                savingDTO.setPaymentMethot(resultSet.getString(11));
                savingDTO.setInterestRate(Float.parseFloat(resultSet.getString(12)));
                savingDTO.setFromDate(resultSet.getString(13));
                savingDTO.setNumberSaving(resultSet.getString(14));
                savingDTO.setUpdateDate(resultSet.getString(15));
                savingDTO.setInsertBy(resultSet.getString(16));
                savingDTO.setStatus(resultSet.getString(17));
                savingDTO.setToDate(resultSet.getString(18));
                list.add(savingDTO);
            }
            statement.close();
            resultSet.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(WithdrawBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void rutso(SavingDTO t) {
        Connection conn = ConnecJDBC.getConn();
        String sql = "update saving set updatedate = ? , insertby = ?, status = ?, period = ?, interestrate = ?, todate = ? where numbersaving = ?";
        try {
            PreparedStatement prestm = conn.prepareStatement(sql);
            prestm.setString(1, t.getUpdateDate());
            prestm.setString(2, t.getInsertBy());
            prestm.setString(3, t.getStatus());
            prestm.setInt(4, t.getPeriod());
            prestm.setFloat(5, t.getInterestRate());
            prestm.setString(6, t.getToDate());
            prestm.setString(7, t.getNumberSaving());
            prestm.executeUpdate();
            conn.close();
            prestm.close();
        } catch (SQLException ex) {
            Logger.getLogger(SavingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

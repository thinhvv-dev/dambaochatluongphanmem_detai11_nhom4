/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SavingDTO;

/**
 *
 * @author NguyenDinhTien
 */
public class WithdrawBookDAO extends ConnecJDBC {

    public static SavingDTO getSaving(String numberSaving, String idCard) {
        SavingDTO savingDTO = new SavingDTO();
        String sql = "select * from saving where numbersaving = '"+numberSaving+"' and idcard = '"+idCard+"'";
        Connection conn = ConnecJDBC.getConn();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                savingDTO.setId(Integer.parseInt(resultSet.getString(1)));
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
            }
            statement.close();
            resultSet.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(WithdrawBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return savingDTO;
    }
}

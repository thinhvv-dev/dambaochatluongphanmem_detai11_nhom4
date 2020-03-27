/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PaymentMethotDTO;

/**
 *
 * @author NguyenDinhTien
 */
public class PaymentMethotDAO extends ConnecJDBC{
    public static List<PaymentMethotDTO> doGetList(){
        Connection conn = ConnecJDBC.getConn();
        List<PaymentMethotDTO> listPaymentMethotDTOs = new ArrayList<>();
        String sql = "select * from paymentmethot";
        
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                PaymentMethotDTO paymentMethotDTO = new PaymentMethotDTO();
                paymentMethotDTO.setId(resultSet.getInt(1));
                paymentMethotDTO.setName(resultSet.getString(2));
                listPaymentMethotDTOs.add(paymentMethotDTO);
            }
            statement.close();
            resultSet.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentMethotDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPaymentMethotDTOs;
    }
}

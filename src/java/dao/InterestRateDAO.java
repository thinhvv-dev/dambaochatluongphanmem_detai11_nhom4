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
import model.InterestRateDTO;
/**
 *
 * @author NguyenDinhTien
 */
public class InterestRateDAO extends ConnecJDBC{
    
    public static List<InterestRateDTO> getAllbyID(int ID) {
        Connection conn = ConnecJDBC.getConn();
        List<InterestRateDTO> lists = new ArrayList<>();
        String sql = "select * from interestrate where currencyId = "+ID;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                InterestRateDTO interRate = new InterestRateDTO();
                interRate.setID(resultSet.getInt(1));
                interRate.setCurrencyId(resultSet.getInt(2));
                interRate.setPeriod(resultSet.getInt(3));
                interRate.setInterestRate(resultSet.getFloat(4));
                lists.add(interRate);
            }
            statement.close();
            resultSet.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InterestRateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }
}

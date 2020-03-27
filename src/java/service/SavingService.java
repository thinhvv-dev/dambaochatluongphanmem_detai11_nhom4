/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.InterestRateDAO;
import dao.PaymentMethotDAO;
import dao.SavingDAO;
import java.util.List;
import model.InterestRateDTO;
import model.PaymentMethotDTO;
import model.SavingDTO;

/**
 *
 * @author NguyenDinhTien
 */
public class SavingService {
    
    public static List<InterestRateDTO> getAllInterestRate(int ID){
        return InterestRateDAO.getAllbyID(ID);
    }
    public static List<PaymentMethotDTO> getAllPaymentMethot(){
        return PaymentMethotDAO.doGetList();
    }
    
    public static void insertSaving(SavingDTO savingDTO){
        SavingDAO.insertSaving(savingDTO);
    }
}

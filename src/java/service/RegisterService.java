/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RegisterDAO;
import model.BankAccountDTO;

/**
 *
 * @author NguyenDinhTien
 */
public class RegisterService {
    public static void insertBankAccount(BankAccountDTO bankAccountDTO, int id){
        RegisterDAO.insertBankAccount(bankAccountDTO,id);
    }
}

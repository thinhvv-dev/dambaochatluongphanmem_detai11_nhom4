/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RegisterandLoginDAO;
import model.Account;

/**
 *
 * @author NguyenDinhTien
 */
public class RegisterandLoginService {
    public static Account getAccount(String userName){
        return RegisterandLoginDAO.getAccount(userName);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.PassWordEncoder;
import service.RegisterandLoginService;

/**
 *
 * @author NguyenDinhTien
 */
@WebServlet(urlPatterns = {""})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        Account account = RegisterandLoginService.getAccount(userName);
        try {
            if (account.getPassWord().equals(PassWordEncoder.encoder(passWord))) {
                HttpSession session = req.getSession();
                session.setAttribute("account", account);
                if(account.getRole().equals("Staff")){
                    resp.sendRedirect("/admin/home");
                }
                else{
                    resp.sendRedirect("/customer/home");
                }
            }
            else{
                resp.sendRedirect("");
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

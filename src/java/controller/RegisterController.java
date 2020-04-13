/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RegisterDAO;
import dao.RegisterandLoginDAO;
import java.io.IOException;
import java.math.BigDecimal;
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
import model.BankAccountDTO;
import service.RegisterService;

/**
 *
 * @author NguyenDinhTien
 */
@WebServlet(urlPatterns = {"/admin/register"})
public class RegisterController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("numberaccount", System.currentTimeMillis());
        RequestDispatcher rd = req.getRequestDispatcher("/adm/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account user = (Account) session.getAttribute("account");
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setFullName(req.getParameter("name"));
        bankAccountDTO.setAddress(req.getParameter("address"));
        bankAccountDTO.setPhone(req.getParameter("phone"));
        bankAccountDTO.setEmail(req.getParameter("email"));
        bankAccountDTO.setIdcard(req.getParameter("idcard"));
        bankAccountDTO.setBanknumber(req.getParameter("numberaccount"));
        bankAccountDTO.setAccountBalance(new BigDecimal(req.getParameter("sodu")));
        bankAccountDTO.setStatus("Active");
        RegisterService.insertBankAccount(bankAccountDTO, user.getID());
        try {
            RegisterandLoginDAO.Register(bankAccountDTO);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect("/admin/home");
    }
    
    
    
}

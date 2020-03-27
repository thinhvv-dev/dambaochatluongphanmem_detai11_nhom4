/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BankAccountDTO;
import service.RegisterService;

/**
 *
 * @author NguyenDinhTien
 */
@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("numberaccount", System.currentTimeMillis());
        RequestDispatcher rd = req.getRequestDispatcher("/adm/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setFullName(req.getParameter("name"));
        bankAccountDTO.setAddress(req.getParameter("address"));
        bankAccountDTO.setPhone(req.getParameter("phone"));
        bankAccountDTO.setEmail(req.getParameter("email"));
        bankAccountDTO.setIdcard(req.getParameter("idcard"));
        bankAccountDTO.setBanknumber(req.getParameter("numberaccount"));
        bankAccountDTO.setAccountBalance(new BigDecimal("0"));
        bankAccountDTO.setStatus("Active");
        RegisterService.insertBankAccount(bankAccountDTO);
        resp.sendRedirect("");
    }
    
    
    
}

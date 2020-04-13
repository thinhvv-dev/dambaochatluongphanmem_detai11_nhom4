/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cus;

import dao.TaikhoanDAO;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import model.InterestRateDTO;
import model.PaymentMethotDTO;
import model.SavingDTO;
import service.SavingService;
/**
 *
 * @author NguyenDinhTien
 */
@WebServlet(urlPatterns = {"/customer/moso"})
public class Moso extends HttpServlet {

    private BankAccountDTO bankAccountDTO = new BankAccountDTO();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account user = (Account) session.getAttribute("account");
        BankAccountDTO saving = TaikhoanDAO.getSaving(user.getSotaikhoan(), user.getIDcard());
        this.bankAccountDTO = saving;
        System.out.println(saving.toString());
        req.setAttribute("saving", saving);
        List<InterestRateDTO> list = SavingService.getAllInterestRate(1);
        List<PaymentMethotDTO> listPayment = SavingService.getAllPaymentMethot();
        System.out.println(list.size());
        System.out.println(listPayment.size());
        req.setAttribute("lists", list);
        req.setAttribute("listPayments", listPayment);
        req.setAttribute("numbersaving", System.currentTimeMillis());
        RequestDispatcher rd = req.getRequestDispatcher("/cus/moso.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        SavingDTO savingDTO = new SavingDTO();
        savingDTO.setPeriod(Integer.parseInt(req.getParameter("period")));
        savingDTO.setInterestRate(Float.parseFloat(req.getParameter("interestRate")));
        savingDTO.setAddress(this.bankAccountDTO.getAddress());
        savingDTO.setCurrency(req.getParameter("currency"));
        savingDTO.setDesposite(new BigDecimal(req.getParameter("desposite")));
        savingDTO.setEmail(this.bankAccountDTO.getEmail());
        savingDTO.setFullName(this.bankAccountDTO.getFullName());
        savingDTO.setPhone(this.bankAccountDTO.getPhone());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String fromDate = format.format(date);
        savingDTO.setFromDate(fromDate);
        savingDTO.setIdCard(this.bankAccountDTO.getIdcard());
        savingDTO.setIssueBy("NaN");
        savingDTO.setInsertBy(this.bankAccountDTO.getBanknumber());
        savingDTO.setNumberSaving(req.getParameter("numbersaving"));
        savingDTO.setPaymentMethot(req.getParameter("paymentMethot"));
        savingDTO.setUpdateDate(fromDate);
        savingDTO.setStatus("Active");
        savingDTO.setToDate(req.getParameter("todate"));
        SavingService.insertSaving(savingDTO);
        TaikhoanDAO.moso(this.bankAccountDTO.getBanknumber(), req.getParameter("desposite"));
        resp.sendRedirect("/customer/home");
    }
    
    
}

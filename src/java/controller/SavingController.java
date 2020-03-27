/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.InterestRateDTO;
import model.PaymentMethotDTO;
import model.SavingDTO;
import service.SavingService;

/**
 *
 * @author NguyenDinhTien
 */
@WebServlet(urlPatterns = {"/saving"})
public class SavingController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<InterestRateDTO> list = SavingService.getAllInterestRate(1);
        List<PaymentMethotDTO> listPayment = SavingService.getAllPaymentMethot();
        req.setAttribute("lists", list);
        req.setAttribute("listPayments", listPayment);
        req.setAttribute("numbersaving", System.currentTimeMillis());
        RequestDispatcher rd = req.getRequestDispatcher("/adm/saving.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        SavingDTO savingDTO = new SavingDTO();
        savingDTO.setPeriod(Integer.parseInt(req.getParameter("period")));
        savingDTO.setInterestRate(Float.parseFloat(req.getParameter("interestRate")));
        savingDTO.setAddress(req.getParameter("address"));
        savingDTO.setCurrency(req.getParameter("currency"));
        savingDTO.setDesposite(new BigDecimal(req.getParameter("desposite")));
        savingDTO.setEmail(req.getParameter("email"));
        savingDTO.setFullName(req.getParameter("name"));
        savingDTO.setPhone(req.getParameter("phone"));
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String fromDate = format.format(date);
        savingDTO.setFromDate(fromDate);
        savingDTO.setIdCard(req.getParameter("idcard"));
        savingDTO.setIssueBy(req.getParameter("issuedBy"));
        savingDTO.setInsertBy("admin");
        savingDTO.setNumberSaving(req.getParameter("numbersaving"));
        savingDTO.setPaymentMethot(req.getParameter("paymentMethot"));
        savingDTO.setUpdateDate(fromDate);
        savingDTO.setStatus("Active");
        savingDTO.setToDate(req.getParameter("todate"));
        SavingService.insertSaving(savingDTO);
        resp.sendRedirect("");
    }
}

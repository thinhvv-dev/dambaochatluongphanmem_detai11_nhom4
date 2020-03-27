/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.InterestRateDTO;
import model.PaymentMethotDTO;
import service.SavingService;

/**
 *
 * @author NguyenDinhTien
 */
@WebServlet(urlPatterns = {"/interestrate"})
public class InterestRateController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<InterestRateDTO> list = SavingService.getAllInterestRate(1);
        List<PaymentMethotDTO> listPayment = SavingService.getAllPaymentMethot();
        req.setAttribute("lists", list);
        req.setAttribute("listPayments", listPayment);
        RequestDispatcher rd = req.getRequestDispatcher("/adm/interestrate.jsp");
        rd.forward(req, resp);
    }
    
}

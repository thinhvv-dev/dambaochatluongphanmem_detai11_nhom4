/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cus;

import dao.SavingDAO;
import dao.TaikhoanDAO;
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
import javax.servlet.http.HttpSession;
import model.Account;
import model.InterestRateDTO;
import model.PaymentMethotDTO;
import model.SavingDTO;
import service.SavingService;
import service.WithdrawBookService;

/**
 *
 * @author NguyenDinhTien
 */
@WebServlet(urlPatterns = {"/customer/rutso"})
public class Rutso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String savingBook = req.getParameter("savingbook");
        String idCard = req.getParameter("idcard");
        SavingDTO saving = WithdrawBookService.getSaving(savingBook, idCard);
        List<InterestRateDTO> list = SavingService.getAllInterestRate(1);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPeriod() == 0) {
                req.setAttribute("anticipatory", list.get(i).getInterestRate());
                break;
            }
        }
        req.setAttribute("saving", saving);
        RequestDispatcher rd = req.getRequestDispatcher("/cus/rutso.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Account user = (Account) session.getAttribute("account");
        String soso = req.getParameter("mySavingNumber");
        SavingDTO savingDTO = new SavingDTO();
        savingDTO.setNumberSaving(soso);
        savingDTO.setStatus("Đã rút sổ");
        savingDTO.setPeriod(Integer.parseInt(req.getParameter("anticipatory")));
        savingDTO.setInterestRate(Float.parseFloat(req.getParameter("myInterestRate")));
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String fromDate = format.format(date);
        savingDTO.setUpdateDate(fromDate);
        savingDTO.setToDate(fromDate);
        
        savingDTO.setInsertBy(user.getSotaikhoan());
        int k = TaikhoanDAO.rutso(user.getSotaikhoan(), req.getParameter("sotiennhan"));
        SavingDAO.rutso(savingDTO);
        resp.sendRedirect("/customer/home");
    }
    

}

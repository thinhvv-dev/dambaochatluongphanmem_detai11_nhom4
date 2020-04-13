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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.InterestRateDTO;
import model.SavingDTO;
import service.SavingService;
import service.WithdrawBookService;

/**
 *
 * @author NguyenDinhTien
 */
@WebServlet(urlPatterns = {"/admin/withdrawbook"})
public class WithdrawBookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/adm/withdrawbook.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String savingBook = req.getParameter("savingbook");
        String idCard = req.getParameter("idcard");
        SavingDTO saving = WithdrawBookService.getSaving(savingBook, idCard);
        if (saving.getId() == 0) {
            resp.sendRedirect("/admin/withdrawbook?message=error");
        } else {
            List<InterestRateDTO> list = SavingService.getAllInterestRate(1);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPeriod() == 0) {
                    req.setAttribute("anticipatory", list.get(i).getInterestRate());
                    break;
                }
            }
            req.setAttribute("saving", saving);
            RequestDispatcher rd = req.getRequestDispatcher("/adm/book.jsp");
            rd.forward(req, resp);
        }
    }

}

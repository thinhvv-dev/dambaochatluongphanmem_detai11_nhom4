/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.TaikhoanDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BankAccountDTO;
import model.InterestRateDTO;
import model.SavingDTO;
import service.SavingService;
import service.WithdrawBookService;
/**
 *
 * @author NguyenDinhTien
 */
@WebServlet(urlPatterns = {"/admin/naptien"})
public class NaptienController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/adm/naptien.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String numberAccount = req.getParameter("numberaccount");
        String idCard = req.getParameter("idcard");
        BankAccountDTO saving = TaikhoanDAO.getSaving(numberAccount, idCard);
        if (saving.getId() == 0) {
            resp.sendRedirect("/admin/naptien?message=khongtimthay");
        } else {
            req.setAttribute("saving", saving);
            RequestDispatcher rd = req.getRequestDispatcher("/adm/thongtintaikhoan.jsp");
            rd.forward(req, resp);
        }
    }
    
}

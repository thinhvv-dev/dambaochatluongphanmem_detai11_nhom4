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
@WebServlet(urlPatterns = {"/customer/danhsachtaikhoantietkiem"})
public class Danhsachtaikhoantietkiem extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account user = (Account) session.getAttribute("account");
        List<SavingDTO> listSaving = SavingDAO.getList(user.getSotaikhoan());
        req.setAttribute("listSaving", listSaving);
        RequestDispatcher rd = req.getRequestDispatcher("/cus/danhsachtaikhoantietkiem.jsp");
        rd.forward(req, resp);
    }
    
}

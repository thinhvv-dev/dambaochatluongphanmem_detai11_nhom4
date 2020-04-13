/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.TaikhoanDAO;
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
@WebServlet(urlPatterns = {"/admin/xacnhannoptien"})
public class Thongtintaikhoan extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("banknumber");
        String sodu = req.getParameter("sodu");
        if(TaikhoanDAO.naptien(number, sodu)!=0){
            resp.sendRedirect("/admin/home");
        }
        else{
            resp.sendRedirect("/admin/naptien?message=error");
        }
    }

    
    
}

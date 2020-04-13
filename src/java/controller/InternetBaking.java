/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NguyenDinhTien
 */
@WebServlet(urlPatterns = {"/admin/internetbanking"})
public class InternetBaking extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random rd = new Random();
        int pass = 100000 + rd.nextInt(900000);
        req.setAttribute("pass", pass);
        RequestDispatcher reqd = req.getRequestDispatcher("/adm/internetbanking.jsp");
        reqd.forward(req, resp);
    }
    
}

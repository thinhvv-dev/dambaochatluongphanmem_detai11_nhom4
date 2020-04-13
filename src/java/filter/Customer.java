/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author NguyenDinhTien
 */
@WebFilter(urlPatterns = {"/customer/*"})
public class Customer implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Account user = (Account) session.getAttribute("account");
        if(user == null){
            resp.sendRedirect("/");
        }
        else{
            if(user.getRole().equals("Customer")){
                chain.doFilter(request, response);
            }
            else{
                resp.sendRedirect("/?message=author error");
            }
        }
    }

    @Override
    public void destroy() {
        
    }
}


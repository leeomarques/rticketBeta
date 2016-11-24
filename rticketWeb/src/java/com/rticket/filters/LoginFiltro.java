//package com.rticket.filters;
//
//import com.rticket.beans.LoginBean;
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@WebFilter("*.xhtml")
//public class LoginFiltro implements Filter{
//    
//    public void doFilter(ServletRequest request, ServletResponse response,
//        FilterChain chain) throws IOException, ServletException {
//        
//    
//	HttpServletRequest req = (HttpServletRequest) request;
//	HttpSession sessao = req.getSession();
//        
//	if (sessao == null || sessao.getAttribute("loginBean") == null || 
//	     ((LoginBean) sessao.getAttribute("loginBean")).getUser() == null) {
//	    RequestDispatcher dis = request.getRequestDispatcher("/index.xhtml");
//  	    dis.forward(request, response);
//	} else {
//	    chain.doFilter(request, response);
//	}
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        
//    }
//
//    @Override
//    public void destroy() {
//        
//    }
//}

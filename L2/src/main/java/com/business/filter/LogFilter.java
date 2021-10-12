package com.business.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LogFilter",
        urlPatterns = {"/input"})
public class LogFilter implements Filter {

    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String remoteAddress =  request.getRemoteAddr();
        String uri = ((HttpServletRequest) request).getRequestURI();
        String protocol = request.getProtocol();

        chain.doFilter(request, response);

        filterConfig.getServletContext().log("Logging Filter Servlet called");
        filterConfig.getServletContext().log("**************************");
        filterConfig.getServletContext().log("User Logged !  User IP: " + remoteAddress + " Resource File: " + uri + " Protocol: " + protocol);
        filterConfig.getServletContext().log(request.getParameter("key"));
        filterConfig.getServletContext().log(request.getParameter("value"));
        filterConfig.getServletContext().log(request.getParameter("category"));
    }
}

package com.business.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "DecoratorFilter",
        urlPatterns = {"/*"})
public class DecorateFilter implements Filter{
    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        out.println("<!-- PRELUDE -->");

        chain.doFilter(request, response);

        out.println("<!-- CODA -->");
    }
}

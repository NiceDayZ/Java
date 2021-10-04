package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WebServ", value = "/web")
public class WebServ extends HttpServlet {
    RequestService requestService = new RequestService();

    final Object lock = new Object();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestType requestType = new RequestType(request);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        this.log("[Request] IP: " + request.getRemoteAddr() + " |user-agent: " + request.getHeader("User-Agent") + " |language: " + request.getHeader("Accept-Language") + " |" + requestType);

        if(requestType.isMock()){
            out.println("<h3>Mock message</h3>");
            return;
        }

        if(requestType.isSync()){
            synchronized (lock) {
                requestService.writeInRepository(requestType);
            }
        }else{
            requestService.writeInRepository(requestType);
        }


        out.println(requestService.formatHTML(requestService.readFromRepository()));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

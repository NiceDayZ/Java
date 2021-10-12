package com.web;

import com.business.service.RecordService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InputServlet", value = "/input")
public class InputServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/input.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // validate the Captcha to check we're not dealing with a bot
        RecordService recordService = new RecordService();
        boolean isHuman = Integer.parseInt(request.getParameter("capchaAns")) == Integer.parseInt(request.getParameter("capcha"));
        PrintWriter out = response.getWriter();

        if (!isHuman) {
            // Captcha validation failed, show error message
            out.println("<h1 class=\"incorrect\">Incorrect capcha</h1>");
        } else {
            // Captcha validation passed, perform protected action
            boolean addRecord = recordService.addRecord(request);
            if(addRecord){
                out.println("<h1 class=\"correct\">Movie added successfully</h1>");
            }else{
                out.println("<h1 class=\"incorrect\">Something went wrong adding the movie</h1>");
            }
        }
    }
}

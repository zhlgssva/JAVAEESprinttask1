package com.example.bitlabee.sprinttask;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "details", value = "/details")
public class TaskDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        Tasks task = DBManager.getTask(id);
        if (task!=null){
            request.setAttribute("task",task);
            request.getRequestDispatcher("/taskDetails.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/404.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

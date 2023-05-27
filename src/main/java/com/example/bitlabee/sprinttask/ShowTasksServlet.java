package com.example.bitlabee.sprinttask;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "showTasks", value = "/showTasks")
public class ShowTasksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Tasks> tasks = DBManager.getTasks();
        request.setAttribute("tasksAttribute", tasks);
        request.getRequestDispatcher("/showTasks.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

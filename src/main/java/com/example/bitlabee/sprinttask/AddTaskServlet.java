package com.example.bitlabee.sprinttask;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "addTask", value = "/addTask")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("task_name");
        String description = request.getParameter("task_description");
        String deadlineDate = request.getParameter("task_deadlineDate");
        Tasks task = new Tasks();
        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(deadlineDate);
        DBManager.addTask(task);
        response.sendRedirect("/showTasks");
    }
}

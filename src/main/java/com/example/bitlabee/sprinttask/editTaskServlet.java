package com.example.bitlabee.sprinttask;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "editTask", value = "/editTask")
public class editTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("task_id"));
        String name = request.getParameter("task_name");
        String description = request.getParameter("task_description");
        String deadlineDate = request.getParameter("task_deadlineDate");
        String isDoneText = request.getParameter("taskIsDone");
        boolean isDone;
        if (isDoneText.equals("true")){
            isDone = true;
        }else {
            isDone = false;
        }
        DBManager.editTask(id,name,description,deadlineDate,isDone);
        response.sendRedirect("/details?id=" + id);
    }
}

package com.example.gigacontrolreporte.servlets;

import com.example.gigacontrolreporte.beans.BUsarios;
import com.example.gigacontrolreporte.daos.UsersDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "adminServlet", value = "listaUsuarios.jsp")
public class adminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // try(PrintWriter printWriter = response.getWriter()){
           // printWriter.println("Esto sería el inicio de admin");
        //}
        UsersDao usersDao = new UsersDao();
        ArrayList<BUsarios> listaUsuarios = usersDao.getUsersList();
        request.setAttribute("lista",listaUsuarios);
        RequestDispatcher view = request.getRequestDispatcher("listaUsuarios.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

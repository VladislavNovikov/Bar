package app.servlets;

import app.javaclasses.JDBCClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowCocktailsList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{


        ArrayList<String> cocktailsList = JDBCClass.getCocktailsList(req);
        req.setAttribute("cocktailsList",cocktailsList);
        req.getRequestDispatcher("views/cocktailsList.jsp").forward(req, resp);
    }
}

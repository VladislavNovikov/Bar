package app.servlets;

import app.javaclasses.JDBCClass;
import app.javaclasses.Recipe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveCocktail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/StartPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       //JDBCClass.Init();

        if(JDBCClass.putReq(req)){
            req.setAttribute("success",true);
            req.getRequestDispatcher("/views/StartPage.jsp").forward(req, resp);
        }


       // writer.println("After some time I'll be able to save some information to database :)");
        //req.getRequestDispatcher("views/cocktailsList.jsp").forward(req, resp);
    }

}

package revMetrix.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import revMetrix.controller.AllAccountsController;
import revMetrix.controller.GameController;
import revMetrix.db.model.Ball;
import revMetrix.model.RevMetrix;

public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        System.out.println("Index Servlet: doGet");

        String destIn = req.getParameter("destination");
        String destOut = null;
        String loggedInName = "";
        

        AllAccountsController controller = new AllAccountsController();
        boolean loggedIn = controller.isLoggedInAccount();
        
        if (loggedIn) {
        	loggedInName = "Hello, " + controller.findLoggedInUser();
        	System.out.println("Logged in name: " + loggedInName);
        }

        // Forward based on the action parameter
        if ("RevMetrix".equals(destIn)) {
           destOut = "/_view/index.jsp";
        } 
        else if ("login".equals(destIn)) {
             destOut = "/_view/login.jsp";
        } 
        else if ("logout".equals(destIn)) {
            destOut = "/_view/login.jsp";
            controller.logOutAllAccounts();
            loggedInName = "";
       } 
        else if ("event".equals(destIn)) {
             destOut = "/_view/event.jsp";
        } 
        else if ("register".equals(destIn)) {
            destOut = "/_view/registration.jsp";
        } 
        else if ("account".equals(destIn)) {
            destOut = "/_view/account.jsp";
        }  
        else if ("game".equals(destIn)) {
            destOut = "/game";
            //req.getRequestDispatcher("/game").forward(req, resp);
        } 
        else if ("stats".equals(destIn)) {
            destOut = "/_view/stats.jsp";    
        } 
        else if ("create".equals(destIn)) {
            destOut = "/_view/create.jsp";
        } 
        else if ("createLeague".equals(destIn)) {
            destOut = "/_view/createLeague.jsp";
        }
        else if ("createPractice".equals(destIn)) {
            destOut = "/_view/createPractice.jsp";
        }
        else if ("createTournament".equals(destIn)) {
            destOut = "/_view/createTournament.jsp";
        }
        else if ("leagues".equals(destIn)) {
            destOut = "/_view/leagues.jsp";
        }
        else if ("practices".equals(destIn)) {
            destOut = "/_view/practices.jsp";
        }
        else if ("tournaments".equals(destIn)) {
            destOut = "/_view/tournaments.jsp";
        }
        else if ("yourGames".equals(destIn)) {
            destOut = "/_view/yourGames.jsp";
        }
        else if ("accountCreation".equals(destIn)) {
            destOut = "/_view/accountCreation.jsp";
        }
        else {
           destOut = "/_view/index.jsp";
        }

        req.setAttribute("loggedInName", loggedInName);
        req.setAttribute("loggedIn", loggedIn);

        // Forward the request after setting destOut
        req.getRequestDispatcher(destOut).forward(req, resp);
    }
}

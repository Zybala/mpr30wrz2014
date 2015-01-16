package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.User;
import repositories.IRepositoryCatalog;
import repositories.implement.RepositoryCatalog;
import WorkUnit.IWorkUnit;
import WorkUnit.WorkUnit;

public class UserShowServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	UserServletLogic logic = new UserServletLogic();
    public ShowUsersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.getWriter().print(logic.showUsersInhtmlForm());
		
	}
	

}

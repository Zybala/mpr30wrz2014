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
import servlets.UserServletLogic;
import WorkUnit.IWorkUnit;
import WorkUnit.WorkUnit;


public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UserServletLogic logic = new UserServletLogic();
	
    public AddUserServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		logic.addNewUser(request);
		response.sendRedirect("ShowUsers");
	}

}

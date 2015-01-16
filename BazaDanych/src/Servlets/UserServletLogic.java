package Servlets;

import javax.servlet.http.HttpServletRequest;

import main.User;
import repositories.IRepositoryCatalog;
import repositories.implement.RepositoryCatalogProvider;


public class UserServletLogic {


	IRepositoryCatalog catalog;
	
	public UserServletLogic() {
		catalog = RepositoryCatalogProvider.catalog();
	}
	
	public void addNewUser(HttpServletRequest request)
	{
		User u = new User();
		u.setLogin(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		catalog.getUsers().save(u);
		catalog.commit();
	}
	
	public String showUsersInhtmlForm()
	{
		String html = "<ol>";
		for(User u: catalog.getUsers().getAll())
		{
			html+="<li>"
					+ u.getUsername()
					+ "</li>";
		}
		html+="</ol>";
		return html;
	}
	

}



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import main.User;
import main.*;
import repositories.implement.RepositoryCatalog;
import repositories.implement.Repository;
import repositories.IRepository;
import repositories.IRepositoryCatalog;
import repositories.implement.DummyRepositoryCatalog;
import repositories.implement.UserBuilder;
import repositories.implement.UserRepository;
import WorkUnit.IWorkUnit;
import WorkUnit.WorkUnit;


public class Main {

	
	public static void main(String[] args) {
String url ="jdbc:hsqldb:hsql://localhost/workdb";
		
		User wojciech = new User();
		wojciech.setUsername("zybala");
		wojciech.setPassword("q1w2e3r4");
		
		try 
		{
			Connection connection = DriverManager.getConnection(url);
			IWorkUnit uow = new WorkUnit(connection);
			
			IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
			
			
			catalog.getUsers().save(wojciech);
			
			List<User> usersFromDb= catalog.getUsers().getAll();
			
			for(User userFromDb: usersFromDb)
				System.out.println(userFromDb.getNumber()+" "+userFromDb.getUsername()+" "+userFromDb.getPassword());
			
			User u = catalog.getUsers().get(2);
			u.setPassword("1qaz2wsx");
			catalog.getUsers().update(u);
			catalog.getUsers().delete(usersFromDb.get(0));
		
			for(User userFromDb: catalog.getUsers().getAll())
				System.out.println(userFromDb.getNumber()+" "+userFromDb.getUsername()+" "+userFromDb.getPassword());
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("koniec");
	}

}
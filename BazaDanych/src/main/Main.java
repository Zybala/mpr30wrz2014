package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import main.*;
import repositories.implement.Repository;
import repositories.IRepositoryCatalog;
import repositories.implement.DummyRepositoryCatalog;
import repositories.implement.UserRepository;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
String url ="jdbc:hsqldb:hsql://localhost/workdb";
		
		User wojciech = new User();
		wojciech.setUsername("zybala");
		wojciech.setPassword("q1w2e3r4");
		
		try 
		{
			Connection connection = DriverManager.getConnection(url);
			
			Repository<User> users = new UserRepository(connection);
			users.save(wojciech);
			List<User> usersFromDb = users.getAll();
			
			for(User userFromDb : usersFromDb)
				System.out.println(userFromDb.getNumber()+" "+userFromDb.getUsername()+" "+userFromDb.getPassword());
			User user = users.get(1);
			user.setPassword("q1w2e3r4");
			users.update(user);
			users.delete(usersFromDb.get(0));
			for(User userFromDb : users.getAll())
				System.out.println(userFromDb.getNumber()+" "+userFromDb.getUsername()+" "+userFromDb.getPassword());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("stop");
	}

}
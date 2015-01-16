package repositories.implement;

import java.sql.Connection;

import main.Person;
import main.Role;
import repositories.IRepository;
import repositories.IRepositoryCatalog;
import repositories.IUserRepository;
import WorkUnit.IWorkUnit;

public class RepositoryCatalog implements IRepositoryCatalog {

	private Connection connection;
	private IWorkUnit uow;
	
	public RepositoryCatalog(Connection connection, IWorkUnit uow) {
		super();
		this.connection = connection;
		this.uow = uow;
	}

	
	public IUserRepository getUsers() {
		return new UserRepository(connection, new UserBuilder(), uow);
	}

	
	public IRepository<Person> getPersons() {
		return new PersonRepository(connection, new PersonBuilder(), uow);
	}


	public IRepository<Role> getRoles() {
		return null;
	}

	
	public void commit() {
		uow.commit();
	}
	
}

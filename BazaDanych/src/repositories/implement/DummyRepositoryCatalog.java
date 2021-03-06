package repositories.implement;

import main.Person;
import main.Role;
import repositories.IRepository;
import repositories.IRepositoryCatalog;
import repositories.IUserRepository;


public class DummyRepositoryCatalog implements IRepositoryCatalog{

	private DummyDb db = new DummyDb();
	
	public IUserRepository getUsers() {
		return new DummyUserRepository(db);
	}

	public IRepository<Person> getPersons() {
		return new DummyPersonRepository(db);
	}
	
	public IRepository <Role> getRoles () {
		return new DummyRoleRepository(db);
	}

}

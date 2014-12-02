package repositories;

import main.Person;


public interface IRepositoryCatalog {

	public IUserRepository getUsers();
	public IRepository<Person> getPersons();
}

package repositories.implement;

import java.util.List;

import main.Person;

import repositories.IRepository;


public class DummyPersonRepository implements IRepository<Person>{

	private DummyDb db;
	
	public DummyPersonRepository(DummyDb db) {
		super();
		this.db = db;
	}

	
	public void save(Person entity) {

		db.persons.add(entity);
		
	}

	
	public void update(Person entity) {
		
	}

	
	public void delete(Person entity) {

		db.persons.remove(entity);
		
	}

	
	public Person get(int Number) {

		for(Person p: db.persons)
			if(p.getNumber()==Number)
				return p;
		return null;
	}

	
	public List<Person> getAll() {
		return db.persons;
	}

}

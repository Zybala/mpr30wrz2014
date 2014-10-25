package impl;

import java.util.ArrayList;
import java.util.List;

import domain.Role;
import domain.User;
import repositories.IUserRepository;

public class DummyUserRepository implements IUserRepository{

	private DummyDb db;
	
	public DummyUserRepository(DummyDb db) {
		super();
		this.db = db;
	}

	
	public void save(User entity) {
		db.users.add(entity);
		
	}

	
	public void update(User entity) {

		
	}

	
	public void delete(User entity) {
		db.users.remove(entity);
		
	}

	
	public User get(int id) {
		for(User u:db.users)
			if(u.getId()==id)
				return u;
		return null;
	}

	
	public List<User> getAll() {

		return db.users;
	}

	
	public List<User> withRole(Role role) {
		return withRole(role.getId());
	}

	
	public List<User> withRole(String roleName) {

		for(Role r:db.roles)
			if(r.getName().equals(roleName))
				return r.getUsers();
		return new ArrayList<User>();
	}

	
	public List<User> withRole(int roleId) {

		for(Role r:db.roles)
			if(r.getId()==roleId)
				return r.getUsers();
		return new ArrayList<User>();
	}

}

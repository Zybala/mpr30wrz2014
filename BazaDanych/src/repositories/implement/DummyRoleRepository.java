package repositories.implement;

import java.util.List;


import repositories.IRepository;
import main.Role;


public class DummyRoleRepository implements IRepository<Role> {

	private DummyDb db;
	
	public DummyRoleRepository(DummyDb db) {
		super();
		this.db = db;
	}
	public void save(Role entity) {
		db.roles.add(entity);
		}

	public void update(Role entity) {
	}

	public void delete(Role entity) {
		db.roles.remove(entity);
	}

	
	public Role get(int Number) {
		
		for(Role role : db.roles)
			if(role.getNumber()==Number)
				return role;
		return null;
	}

	public List<Role> getAll() {
		return db.roles;
	}

}

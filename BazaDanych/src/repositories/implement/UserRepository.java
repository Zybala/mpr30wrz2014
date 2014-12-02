package repositories.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.Person;
import main.Role;
import main.User;

import repositories.IRepository;
import repositories.IUserRepository;

public class UserRepository 
	extends Repository<User>
	implements IUserRepository
{

	protected UserRepository(Connection connection, EntityBuilder<User> builder) {
		super(connection, builder);
	}

	
	protected void setUpUpdateQuery(User entity) throws SQLException {
		update.setString(1, entity.getUsername());
		update.setString(2, entity.getPassword());
		update.setInt(3, entity.getNumber());
	}

	
	protected void setUpInsertQuery(User entity) throws SQLException {	
		insert.setString(1, entity.getUsername());
		insert.setString(2, entity.getPassword());
		
	}

	
	protected String getTableName() {
		return "users";
	}

	
	protected String getInsertQuery() {
		return "INSERT INTO users(login,password) values(?,?)";
	}

	
	protected String getUpdateQuery() {
		return "update users set (login,password)=(?,?) where Number=?";
	}

	
	public List<User> withRole(Role role) {
		
		return null;
	}

	
	public List<User> withRole(String roleName) {
		
		return null;
	}

	
	public List<User> withRole(int roleId) {
		
		return null;
	}

}
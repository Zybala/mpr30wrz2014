package repositories.implement;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.User;

public class UserBuilder implements IEntityBuilder<User> {

	@Override
	public User build(ResultSet rs) throws SQLException {
		User result = new User();
		result.setNumber(rs.getInt("id"));
		result.setUsername(rs.getString("username"));
		result.setPassword(rs.getString("password"));
		return result;
	}

}

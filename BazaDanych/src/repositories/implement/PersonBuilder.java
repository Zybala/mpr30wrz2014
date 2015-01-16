package repositories.implement;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.Person;





public class PersonBuilder implements IEntityBuilder<Person> {
	
	public Person build(ResultSet rs) throws SQLException {
		Person person = new Person();
		person.setNumber(rs.getInt("Number"));
		person.setName(rs.getString("name"));
		person.setSurename(rs.getString("surname"));
		person.setDOB(rs.getString("DOB"));
		return person;

	}
}

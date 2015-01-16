package repositories.implement;


import java.sql.Connection;
import java.sql.SQLException;
import main.Person;
//import repositories.implement.EntityBuilder;

public class PersonRepository extends Repository<Person> {
	

		private String insertSql=
				"INSERT INTO person(name,surname,DOB) VALUES(?,?,?)";
		
		private String updateSql=
				"UPDATE person SET (name,surname,DOB)=(?,?,?) WHERE Number=?";
		
		public PersonRepository(Connection connection, IEntityBuilder<Person> builder) {
			super(connection, builder);
		}
		
		
		protected String getTableName() {
			return "person";
		}

		
		protected String getInsertQuery() {
			return insertSql;
		}

	
		protected String getUpdateQuery() {
			return updateSql;
		}

		
		protected void setUpInsertQuery(Person entity) throws SQLException {
			insert.setString(1, entity.getName());
			insert.setString(2, entity.getSurename());
			insert.setString(3, entity.getDOB());
		}

		
		protected void setUpUpdateQuery(Person entity) throws SQLException {
			update.setString(1, entity.getName());
			update.setString(2, entity.getSurename());
			update.setString(3, entity.getDOB());
			update.setInt(4, entity.getNumber());
		}
	
		

	
}

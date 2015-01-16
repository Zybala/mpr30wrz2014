package repositories.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import main.Entity;

public interface IEntityBuilder<TEntity extends Entity> {
	
	public TEntity build(ResultSet rs) throws SQLException;

}

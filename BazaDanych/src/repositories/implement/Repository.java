package repositories.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repositories.IRepository;
import main.Entity;




public abstract class Repository<TEntity extends Entity> implements IRepository<TEntity>{
	
	protected Connection connection;
	protected PreparedStatement insert;
	protected PreparedStatement selectByNumber;
	protected PreparedStatement update;
	protected PreparedStatement selectAll;
	protected PreparedStatement delete;
	protected IEntityBuilder<TEntity> builder;
	
	protected String selectByIdSql=
			"SELECT * FROM "
			+ getTableName()
			+ " WHERE Number=?";
	protected String deleteSql=
			"DELETE FROM "
			+ getTableName()
			+ " WHERE Number=?";
	protected String selectAllSql=
			"SELECT * FROM "+ getTableName();
	
	protected Repository(Connection connection,IEntityBuilder<TEntity> builder)
	{
		this.builder=builder;
		this.connection = connection;
		try 
		{
			insert = connection.prepareStatement(getInsertQuery());
			selectByNumber=connection.prepareStatement(selectByIdSql);
			update=connection.prepareStatement(getUpdateQuery());
			delete=connection.prepareStatement(deleteSql);
			selectAll=connection.prepareStatement(selectAllSql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void delete(TEntity entity) {
		try {
			delete.setInt(1, entity.getNumber());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	

	
	public void save(TEntity entity) {
		try {
			setUpInsertQuery(entity);
			insert.executeUpdate();
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}
	

	
	public void update(TEntity entity) {
		try {
			setUpUpdateQuery(entity);
			update.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}
	
	
	public TEntity get(int Number) {

		try {
			selectByNumber.setInt(1, Number);
			ResultSet rs = selectByNumber.executeQuery();
			while(rs.next())
			{
				return builder.build(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<TEntity> getAll() {
		List<TEntity> result = new ArrayList<TEntity>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next())
			{
				result.add(builder.build(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	protected abstract void setUpUpdateQuery(TEntity entity) throws SQLException;
	protected abstract void setUpInsertQuery(TEntity entity) throws SQLException;
	protected abstract String getTableName();
	protected abstract String getInsertQuery();
	protected abstract String getUpdateQuery();
}

package WorkUnit;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;




import main.Entity;
import main.EntityState;

public class WorkUnit implements IWorkUnit {
	
private Connection connection;
	
	private Map<Entity, IWorkUnitRepo> entities = 
			new LinkedHashMap<Entity, IWorkUnitRepo>();
	
	public WorkUnit(Connection connection) {
		super();
		this.connection = connection;
		
		try {
			connection.setAutoCommit(false);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void commit() {

		for(Entity entity: entities.keySet())
		{
			switch(entity.getState())
			{
			case Changed:
				entities.get(entity).persistUpdate(entity);
				break;
			case Deleted:
				entities.get(entity).persistDelete(entity);
				break;
			case New:
				entities.get(entity).persistAdd(entity);
				break;
			case Unchanged:
				break;
			default:
				break;}
		}
		
		try {
			connection.commit();
			entities.clear();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public void rollback() {

		entities.clear();
		
	}

	
	public void markAsNew(Entity entity, IWorkUnitRepo repository) {
		entity.setState(EntityState.New);
		entities.put(entity, repository);
		
	}

	
	public void markAsDirty(Entity entity, IWorkUnitRepo repository) {
		entity.setState(EntityState.Changed);
		entities.put(entity, repository);
		
	}

	@Override
	public void markAsDeleted(Entity entity, IIWorkUnitRepo repository) {
		entity.setState(EntityState.Deleted);
		entities.put(entity, repository);
		
	}
	
	
}

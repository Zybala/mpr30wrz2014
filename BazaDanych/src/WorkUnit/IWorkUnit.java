package WorkUnit;


import main.Entity;

public interface IWorkUnit {
	
	public void commit();
	public void rollback();
	public void markAsNew(Entity entity, IWorkUnitRepo repository);
	public void markAsDirty(Entity entity, IWorkUnitRepo repository);
	public void markAsDeleted(Entity entity, IWorkUnitRepo repository);

}

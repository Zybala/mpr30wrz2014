package WorkUnit;

import main.Entity;

public interface IWorkUnitRepo {
	public void persistAdd(Entity entity);
	public void persistUpdate(Entity entity);
	public void persistDelete(Entity entity);

}

package net.tncy.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF
{
	private static EMF instance;
	private EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("transactions-optional");
	private EntityManager em = emfInstance.createEntityManager();
	
	public static EMF getInstance()
	{
		if(instance == null)
			instance = new EMF();
		return instance;
	}
	
	private EMF()
	{
	}

	public EntityManager getEntityManager()
	{
		return em;
	}
}
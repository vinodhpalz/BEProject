package model;

import org.hibernate.Session;

public class SupplierDAO {

	private DBConfig db;
	private Session sess;
	public SupplierDAO()
	{
		db = new DBConfig();
	}
	
	public boolean insertSupplier(Supplier s)
	{
		boolean b = true;
		try
		{
			sess = db.getSess();
			sess.beginTransaction();
			sess.save(s);
			sess.getTransaction().commit();
			
		}catch(Exception ex)
		{
			b = false;
			sess.getTransaction().rollback();
			ex.printStackTrace();
		}
		return b;
	}
	
}

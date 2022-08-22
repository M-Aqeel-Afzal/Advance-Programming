package BussinessLogic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDatabase {
	private static HibernateDatabase single_instance = null;
	Session ses;
	  Transaction trans;
	private HibernateDatabase()
	{
		Configuration con = new Configuration();
		   con.configure("hibernate.cfg.xml");
		   con.configure().addAnnotatedClass(Accounts.class);
		   SessionFactory sf= con.buildSessionFactory();
		  // System.out.println("Please Register yourself!");
		   Session session= sf.openSession();
		   Transaction tran= session.beginTransaction();
	  ses=session;
	  trans=tran;
	  
	}
	public static HibernateDatabase getObj()
    {
        if (single_instance == null)
            single_instance = new HibernateDatabase();
 
        return single_instance;
    }
	public  Session  getSession()
	{
	
	   return this.ses;
	}
	
	public  Transaction getTransaction()
	{
	
	   return trans;
	}
}

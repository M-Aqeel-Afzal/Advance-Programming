import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Driver {
	 public static void main(String[] args) {
	        // loads configuration and creates a session factory
	      
	        Configuration con1 = new Configuration();
	        con1.configure().addAnnotatedClass(Person.class);
	        SessionFactory sf1= con1.buildSessionFactory();
	        Session session1= sf1.openSession();
	        Transaction trans1= session1.beginTransaction();
	        Person p1=new Person();
	        p1.setName("Aqeel");
	        p1.setSurname("Afzal");
	       

	        Car c1=new Car();
	        c1.setOwnerID(1);
	        c1.setLicenePlate("LS1001");
	        c1.setMake("Honda");
	        c1.setModel("2019"); 
	
	       
	    
	        
	        Car c2=new Car();
	        c2.setOwnerID(1);
	        c2.setLicenePlate("LS1111");
	        c2.setMake("Civic");
	        c2.setModel("2021"); 
	        ArrayList<Car> list = new ArrayList<Car>();
	        list.add(c1);
	        list.add(c2);
	        
	     
	      
	    
	      
	        p1.setList(list);
	      
	        
	      //  session1.save(c1);
	      //  session1.save(c2);
	        session1.save(p1);
	        trans1.commit();
	        
	 }
}

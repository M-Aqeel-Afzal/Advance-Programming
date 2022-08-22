package BussinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ExceptionsHandling.AccountNotExist;
import ExceptionsHandling.MemberAllreadyExist;
import ExceptionsHandling.PartyCapecityIsFull;
import ExceptionsHandling.PartyNotFound;
import ExceptionsHandling.PrimaryKeyViolationException;



public class Driver {
	
public static void main(String[] args) throws PrimaryKeyViolationException  
{
	  // loads configuration and creates a session factory
	
	//KametiParty.ShowPartiesofMember(HibernateDatabase.getObj(),1);
   
    
    
   /*
    
   Scanner obj= new Scanner(System.in);                   //party joining
   	System.out.println("joinig a Kameti party");
   	System.out.println("Enter your CNIC");
   	int cnic=obj.nextInt();
   	Accounts acc=null;
	try {
		acc = Accounts.getAccount(HibernateDatabase.getObj().getSession(),cnic);
	} catch (AccountNotExist e1) {
		// TODO Auto-generated catch block
		System.err.print(e1);
	}
   	if(acc!=null)
   	{
   		KametiParty.ShowParties(HibernateDatabase.getObj());
   		System.out.println("Enter Desire Party ID");
   	   	int pid=obj.nextInt();
   	 KametiParty party=null;
	try {
		party = KametiParty.getParty(HibernateDatabase.getObj().getSession(),pid);
	} catch (PartyNotFound e) {
		// TODO Auto-generated catch block
		System.err.print(e);
	}
   //	 ArrayList<KametiMember> mem=new  ArrayList<KametiMember>();
   
   	 if(party!=null)
     {
   		KametiMember.JoinParty(HibernateDatabase.getObj(),party,pid, cnic, acc,HibernateDatabase.getObj().getTransaction());
    
     }
        
       
    	
   	}
   	else
   	{
   		System.out.println("Account not found");
   	}
  
  */
   
    
   //System.out.println( KametiParty.getMembersDetails(11));
    
   /*
    
    Scanner obj= new Scanner(System.in);                   //Deposite
   	System.out.println("Deposite");
   	System.out.println("Enter your CNIC");
   	int cnic=obj.nextInt();
   	Accounts acc=null;
	try {
		acc = Accounts.getAccount(HibernateDatabase.getObj().getSession(),cnic);
	} catch (AccountNotExist e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
   	if(acc!=null)
   	{
   		KametiParty.ShowPartiesofMember(HibernateDatabase.getObj(),cnic);
   		System.out.println("Enter  Party ID");
   	   	int pid=obj.nextInt();
   	   	
   	 System.out.println("Enter  amount");
	   	double am=obj.nextDouble();
   	
   	 KametiParty party=null;
	try {
		party = KametiParty.getParty(HibernateDatabase.getObj().getSession(),pid);
	} catch (PartyNotFound e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		 System.err.print(e);
	}
	
   //	 ArrayList<KametiMember> mem=new  ArrayList<KametiMember>();
   	 if(party!=null)
   		 
     {
   		KametiMember km=new KametiMember();
   		km.Deposite( HibernateDatabase.getObj(), am, cnic,HibernateDatabase.getObj().getTransaction());
     }
        
       
    	 
   	}
   	else
   	{
   		System.out.println("Account not found");
   	}
    */
    
    /*
    Scanner obj= new Scanner(System.in);                   //withdraw
   	System.out.println("withdarw");
   	System.out.println("Enter your CNIC");
   	int cnic=obj.nextInt();
   	Accounts acc=null;
	try {
		acc = Accounts.getAccount(HibernateDatabase.getObj().getSession(),cnic);
	} catch (AccountNotExist e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
   	if(acc!=null)
   	{
   		KametiParty.ShowPartiesofMember(HibernateDatabase.getObj(),cnic);
   		System.out.println("Enter  Party ID");
   	   	int pid=obj.nextInt();
   	   	
   	 KametiParty party=null;
	try {
		party = KametiParty.getParty(HibernateDatabase.getObj().getSession(),pid);
	} catch (PartyNotFound e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   //	 ArrayList<KametiMember> mem=new  ArrayList<KametiMember>();
   	 if(party!=null)
     {
   		KametiMember km=new KametiMember();
   		km.Withdraw( HibernateDatabase.getObj(),cnic,HibernateDatabase.getObj().getTransaction());
     }
        
       
    	 
   	}
   	else
   	{
   		System.out.println("Account not found");
   	}
        
   /*
    Scanner obj= new Scanner(System.in);
	System.out.println("Party deletion");
	System.out.println("Enter your CNIC");
	int cnic=obj.nextInt();
	System.out.println("Enter Kameti ID");
	int kid=obj.nextInt();
	 obj.close();
	
	if(FileFlag)
	{Accounts acc=null;
	try {
		acc = Accounts.getAccount(session,cnic);
	} catch (AccountNotExist e) {
		// TODO Auto-generated catch block
		 System.err.print(e);
	}
	if(acc!=null)
	{
		KametiOwner.Delete_Party( session, kid,cnic, trans) ;
	}
	 
	}
	*/
  
    /*
	Scanner obj= new Scanner(System.in);
	System.out.println("Party creating");
	System.out.println("Enter your CNIC");
	int cnic=obj.nextInt();
	System.out.println("Enter Kameti Name");
	String kname=obj.next();
	System.out.println("Enter Kameti Capecity");
	int capecity=obj.nextInt();
	System.out.println("Enter Installent per month");
	double ins=obj.nextDouble();
	 obj.close();
	
	if(FileFlag)
	{Accounts acc=null;
	try {
		acc = Accounts.getAccount(HibernateDatabase.getObj().getSession(),cnic);
	} catch (AccountNotExist e) {
		// TODO Auto-generated catch block
		 System.err.print(e);
	}
	if(acc!=null)
	{
		 KametiParty kp=new KametiParty(kname);
		 kp.setCapecity(capecity);
		 kp.setInstallment_per_month(ins);
		 kp.setVacant_Position(capecity);
		 kp.setStatus("Active");
		 kp.setOwner_cinc(cnic);
		 
		 ArrayList<KametiParty> pr = new ArrayList<KametiParty>();
		    pr.add(kp);
		 Dates d=new Dates("11/1/12","11/1/12","11/1/12","11/1/12","11/1/12","11/1/12");
		    kp.setDates(d);
		    HibernateDatabase.getObj().getSession().save(kp);
		KametiOwner owner =KametiOwner.getAccount(HibernateDatabase.getObj(),cnic);
		if(owner==null)
		{  owner=new KametiOwner(acc,pr,cnic);
		HibernateDatabase.getObj().getSession().save(owner);
		}
		else
		{
			owner.setParties(kp);
			HibernateDatabase.getObj().getSession().update(owner);
		}
	    
	}
	HibernateDatabase.getObj().getTransaction().commit();
	}
	else
	{
		
		 Dates d=new Dates("11/1/12","11/1/12","11/1/12","11/1/12","11/1/12","11/1/12");
		    KametiOwner owner=new KametiOwner(cnic);
		    KametiParty kp=new KametiParty(kname,capecity,ins,0,capecity,d,cnic);
	}
	*/
    /*
    Scanner obj= new Scanner(System.in);
	System.out.println("Party ");
	System.out.println("Enter your ID");
	String pname=obj.nextLine();
    KametiParty p=new KametiParty(pname);
    p.setKametiName(pname);
    p.setCapecity(15);
    Dates d=new Dates("11/1/12","11/1/12","11/1/12","11/1/12","11/1/12","11/1/12");
    p.setDates(d);
    session.save(p);
    
    ArrayList<KametiParty> pr = new ArrayList<KametiParty>();
    KametiOwner acc=session.get(KametiOwner.class, 3);
    pr.add(p);
    acc.setParties(pr);
    session.update(acc);
    */
       
     /* 
   
    Scanner obj= new Scanner(System.in);
	System.out.println("Please Register yourself!");   //registration
	
	System.out.println("Enter First Name");
	String fname=obj.nextLine();
	System.out.println("Enter Last Name");
	String lname=obj.nextLine();
	System.out.println("Enter CNIC");
	int cnic=obj.nextInt();
	System.out.println("Enter Address");
	String addr=obj.next();
	System.out.println("Enter Contact");
	String cont=obj.next();
	System.out.println("Enter Gender");
	String gen=obj.next();
	 obj.close();
	//KametiParty parties=new KametiParty();
	    
	
         // Create CriteriaBuilder
	 if(FileFlag)
	 {   CriteriaBuilder builder = HibernateDatabase.getObj().getSession().getCriteriaBuilder();

         // Create CriteriaQuery
         CriteriaQuery<Accounts> criteria = builder.createQuery(Accounts.class);

         // Specify criteria root
         criteria.from(Accounts.class);

         // Execute query
         List<Accounts> entityList = HibernateDatabase.getObj().getSession().createQuery(criteria).getResultList();

         for (Accounts e : entityList) {
        	 try {
         if(e.getCNIC()==cnic)
         {
        	 
        	 throw new PrimaryKeyViolationException("Duplicate Primery Key!");
        	  
         }
        	 }
        	 catch (PrimaryKeyViolationException e1) {
     			// TODO Auto-generated catch block
        		 flag=false;
     			 System.err.print(e1);
        	// break;
         }
         }
	 if(flag)
	{HibernateDatabase.getObj().getSession().save(KametiParty.register_member(cnic, fname, lname, addr, cont, gen,FileFlag));
	
	
	HibernateDatabase.getObj().getTransaction().commit();
	}  
	 }
	 else
	 {
		 KametiParty.register_member(cnic, fname, lname, addr, cont, gen,FileFlag);
	 }
        */
 
}
	 
}

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import BussinessLogic.Accounts;
import BussinessLogic.Dates;
import BussinessLogic.HibernateDatabase;
import BussinessLogic.KametiMember;
import BussinessLogic.KametiOwner;
import BussinessLogic.KametiParty;
import ExceptionsHandling.AccountNotExist;
import ExceptionsHandling.PartyNotFound;

public class JUnitTesting {
	static Session session;
	static Transaction trans;
	@BeforeClass
	
	public static void setup()
	{
		 
		    boolean flag=true;
		    boolean FileFlag=true;
		    
		    
		    KametiParty kp=new KametiParty("poc7");
			 kp.setCapecity(10);
			 kp.setInstallment_per_month(500);
			 kp.setVacant_Position(10);
			 kp.setStatus("Active");
			 kp.setOwner_cinc(1);
			 ArrayList<KametiParty> pr = new ArrayList<KametiParty>();
			    pr.add(kp);
			 Dates d=new Dates("11/1/12","11/1/12","11/1/12","11/1/12","11/1/12","11/1/12");
			    kp.setDates(d);
			    HibernateDatabase.getObj().getSession().save(kp);
			    KametiOwner owner =KametiOwner.getAccount(HibernateDatabase.getObj(),1);
				if(owner==null)
				{  try {
					owner=new KametiOwner(Accounts.getAccount(HibernateDatabase.getObj().getSession(),1),pr,1);
				} catch (AccountNotExist e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				HibernateDatabase.getObj().getSession().save(owner);
				}
			  
			    
		   // session.save(KametiParty.register_member(2, "Ali", "Baba", "Isb", "12345", "male",FileFlag));
				HibernateDatabase.getObj().getTransaction().commit();
		
		
	}
	
		@Test
		public void test_Registration() {   
			
			Accounts acc=null;
			try {
				 acc=Accounts.getAccount(HibernateDatabase.getObj().getSession(),1);
			} catch (AccountNotExist e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
			 
			assertNotNull(acc);
			 
			
		}
		
		@Test
		public void test_PartyCreation() {   
			
			KametiParty acc=null;
			try {
				acc=KametiParty.getParty(session,KametiOwner.getAccount(HibernateDatabase.getObj(),1).getParties().get(0).getKameti_ID());
				
			} catch (PartyNotFound e) {
				// TODO Auto-generated catch block
				
			}
			 
			assertNotNull(acc);
			 
			
		}
		@Test
		public void test_PartyDeletion() {   
			KametiOwner.Delete_Party(HibernateDatabase.getObj(),KametiOwner.getAccount(HibernateDatabase.getObj(),1).getParties().get(0).getKameti_ID(),3);
	
			KametiParty acc=null;
			try {
				acc=KametiParty.getParty(session,KametiOwner.getAccount(HibernateDatabase.getObj(),3).getParties().get(0).getKameti_ID());
				System.out.println("kiD  "+acc.getKameti_ID());
				System.out.println("------------->"+acc.getCapecity());
			} catch (PartyNotFound e) {
				// TODO Auto-generated catch block
				
			}
			assertEquals(acc.getStatus(),"Inactive");
			 
			
		}
		
		@Test
		public void test_JoinParty() {   
			Accounts acc=null;
			try {
				acc = Accounts.getAccount(HibernateDatabase.getObj().getSession(),2);
			} catch (AccountNotExist e1) {
				// TODO Auto-generated catch block
				System.err.print(e1);
			}
		   	if(acc!=null)
		   	{
		   		
		   		
		   	 KametiParty party=null;
			try {
				party = KametiParty.getParty(HibernateDatabase.getObj().getSession(),5);
			} catch (PartyNotFound e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
		   //	 ArrayList<KametiMember> mem=new  ArrayList<KametiMember>();
		   	
		   	 if(party!=null)
		     {
		   		KametiMember.JoinParty(HibernateDatabase.getObj(),party,5, 2, acc,HibernateDatabase.getObj().getTransaction());
 
		     }
		       
		  }
		 
			KametiMember acc1=null;
			acc1= KametiMember.getAccount(HibernateDatabase.getObj(), 2);
			assertNotNull(acc1);
			 
			
		}
		
	
		@Test
		public void test_Desposite() {   
			KametiMember acc=null;
			acc = KametiMember.getAccount(HibernateDatabase.getObj(),2);
		   	if(acc!=null)
		   	{
		   		
		   	acc.Deposite(HibernateDatabase.getObj(), 500, 2, HibernateDatabase.getObj().getTransaction());
		   	 
		       
		  }
		 
		   	KametiParty party=null;
			try {
				party = KametiParty.getParty(HibernateDatabase.getObj().getSession(),5);
			} catch (PartyNotFound e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
			
			assertEquals(party.getTotal_Balance(),500.0,0);
			 
			
		}
		
		@Test
		public void test_Withdraw() {   
			KametiMember acc=null;
			acc = KametiMember.getAccount(HibernateDatabase.getObj(),2);
		   	if(acc!=null)
		   	{
		   		
		   	acc.Withdraw(HibernateDatabase.getObj(),2, HibernateDatabase.getObj().getTransaction());
		   	 
		       
		  }
		 
		   	KametiParty party=null;
			try {
				party = KametiParty.getParty(HibernateDatabase.getObj().getSession(),5);
			} catch (PartyNotFound e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
			
			assertEquals(party.getTotal_Balance(),0,0);
			 
			
		}
}

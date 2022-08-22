package BussinessLogic;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cascade;

import DatabaseLayer.Filehandling;
@Entity
@Table(name="KametiOwner")
public class KametiOwner implements Serializable {
	@Id
	private int Owner_CNIC;
	@OneToOne
	private Accounts R_Member;
	private String Agreement = "Aqeel abid sahil umer";
	@Transient
	Session s;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	List<KametiParty> parties;
	public KametiOwner() {
		R_Member=null;

	}
	public KametiOwner(Accounts mem,List<KametiParty> p,int cnic) {
		Owner_CNIC=cnic;
		R_Member= mem;
		parties=p;
	}
	public String getContract() {
		return Agreement;
	}
	public void setContract(String contract) {
		Agreement = contract;
	}
	public KametiOwner(int cnic) {
		Owner_CNIC=cnic;
		Filehandling.KametiOwner_info(this);
	}
	public Accounts getR_Member() {
		return R_Member;
	}
	public void setR_Member(Accounts r_Member) {
		R_Member = r_Member;
	}
	
	public int getOwner_cnic() {
		return Owner_CNIC;
	}
	public void setOwner_cnic(int owner_ID) {
		Owner_CNIC = owner_ID;
	}
	public List<KametiParty> getParties() {
		return parties;
	}
	public void setParties(KametiParty par) {
		this.parties.add(par);
	}
	public Session getSession() {
		return s;
	}
	public void setSession(Session session) {
		this.s = session;
	}
	public void Create_Party(List<KametiParty> parties) {
		this.parties = parties;
	}
	public static void Delete_Party(HibernateDatabase hibr,int kid,int cnic) {
	    CriteriaBuilder builder = hibr.getSession().getCriteriaBuilder();
	    CriteriaQuery<KametiOwner> criteria = builder.createQuery(KametiOwner.class);
	    criteria.from(KametiOwner.class);
	    List<KametiOwner> entityList = hibr.getSession().createQuery(criteria).getResultList();

	    for (KametiOwner e : entityList) {
	    	//System.out.println("cnic:"+e.getOwner_cnic()+"cnic"+e.getOwner_cinc());
	   if(cnic==e.getOwner_cnic()&& e.getParties().get(0).getStatus().equals("Active"))
	   {
		   e.getParties().get(0).setStatus("Inactive");
		 //  hibr.getSession().delete(e);
		   hibr.getSession().update(  e.getParties().get(0));
		   hibr.getTransaction().commit();
	   }
	    }
	}
	static public KametiOwner getAccount(HibernateDatabase hibr,int cnic)
	{
		 
	    CriteriaBuilder builder = hibr.getSession().getCriteriaBuilder();
	    CriteriaQuery<KametiOwner> criteria = builder.createQuery(KametiOwner.class);
	    criteria.from(KametiOwner.class);
	    List<KametiOwner> entityList = hibr.getSession().createQuery(criteria).getResultList();

	    for (KametiOwner e : entityList) {
	    if(e.getOwner_cnic()==cnic)
	    {
	    	
	   	 return e;
	    }
	    }
	    return null;
	}
	

	
}

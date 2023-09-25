package in.mindcraft.InheritanceDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Tester {
	

	public static void main(String[] args) {
		
		Account a = new Account();
		a.setAcc_id(101);
		a.setName("Joel");
		a.setBalance(50000);
		
		SavingAccount sa = new SavingAccount();
		sa.setAcc_id(102);
		sa.setInterestRate(7);
		
		CurrentAccount ca = new CurrentAccount();
		ca.setAcc_id(103);
		ca.setOverlimit(1000);
		
		Configuration con = new Configuration().configure();
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(a);
		session.save(sa);
		session.save(ca);
		tx.commit();
	}

}

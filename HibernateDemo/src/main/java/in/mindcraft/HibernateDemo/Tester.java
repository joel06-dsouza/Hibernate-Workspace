package in.mindcraft.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Tester {

	public static void main(String[] args) {
		
		Laptop l1 = new Laptop();
		l1.setLid(101);
		l1.setMake("HP");

		Laptop l2 = new Laptop();
		l2.setLid(103);
		l2.setMake("Asus");
		
		Student s1 = new Student();
		s1.setRollno(100);
		s1.setName("Joel");

		Student s2 = new Student();
		s1.setRollno(101);
		s1.setName("Praladh");
		
		s1.getList().add(l1);
		s1.getList().add(l2);
			
		l1.getStudent().add(s1);
		l1.getStudent().add(s2);
		
		Configuration con = new Configuration().configure();
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
//		session.flush();
		session.save(l1);
		session.save(l2);
		session.save(s1);
		session.save(s2);
		tx.commit();
		
	}

}

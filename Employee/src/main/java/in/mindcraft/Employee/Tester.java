package in.mindcraft.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address res_add = new Address();
		res_add.setCity("Mumbai");
		res_add.setState("Maharashtra");
		res_add.setStreet("LT Street");
		
		Address off_add = new Address();
		off_add.setCity("Mumbai");
		off_add.setState("Maharashtra");
		off_add.setStreet("Andheri");
		
		
		Employee e1 = new Employee();
		e1.setEmpid(3642);
		e1.setName("Joel");
		
		e1.getList().add(res_add);
		e1.getList().add(off_add);
		
		Configuration con = new Configuration().configure();
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(res_add);
		session.save(off_add);
		session.save(e1);

		
		tx.commit();
	}

}

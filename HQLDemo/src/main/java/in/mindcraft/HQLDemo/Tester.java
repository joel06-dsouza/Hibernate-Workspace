package in.mindcraft.HQLDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Tester {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure();
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

//		MobilePhone m = (MobilePhone) session.get(MobilePhone.class, 102);
//		
//		System.out.println("Details of the Mobile Phone"+m);
		
//		Query qry = session.createQuery("from MobilePhone m where m.cost > 15000");
//		Query qry = session.createQuery("from MobilePhone where cost > 15000");
//		List<MobilePhone> mphone = qry.list();
//		for(MobilePhone m: mphone)
//			System.out.println(m);
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			int choice;
			System.out.println();
			System.out.println("1. Create");
			System.out.println("2. Read");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. Exit");
			System.out.println("Enter Choice: ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				MobilePhone m = new MobilePhone();
				m.getDetails();
				session.save(m);
				System.out.println("Details Entered Succesfully!!");
				break;
			case 2:
				System.out.println("Enter Mobile Id to view Details: ");
				int mid= sc.nextInt();
				MobilePhone mphone = (MobilePhone) session.get(MobilePhone.class, mid);
				System.out.println("Detail of the phone is "+mphone);
//				tx.commit();
				break;
			case 3:
				int id;
				String mname;
				double mcost;
				System.out.print("Enter Mobile Id to make update - ");
				id = sc.nextInt();
				System.out.print("Enter new name of the Mobile Phone - ");
				mname = sc.next();
				System.out.print("Enter the cost of the Mobile Phone - ");
				mcost = sc.nextDouble();
//				Query qry = session.createQuery("UPDATE MobilePhone m set m.cost=4555 where m.mid=105");
//				qry.setParameter(0, mname);
//				qry.setParameter(1, mcost);
//				qry.setParameter(2, id);
				MobilePhone m1 = (MobilePhone) session.get(MobilePhone.class, id);
				m1.setName(mname);
				m1.setCost(mcost);
//				int rst = qry.executeUpdate();
//				System.out.println(rst+" rows affected.");
				session.update(m1);
//				tx.commit();
				break;
				
			case 4:
				int mpid;
				System.out.print("Enter Mobile Id - ");
				mpid = sc.nextInt();
//				Query query = session.createQuery("delete MobilePhone where mid = :mid");
//				query.setInteger("mid", mpid);
//				int del = query.executeUpdate();
//				System.out.println(del+ " rows deleted!!");
				MobilePhone m2 = (MobilePhone) session.get(MobilePhone.class, mpid);
				session.delete(m2);
				System.out.println("Deleted Successfully!!!");
//				tx.commit();
				break;
				
			case 5:
				tx.commit();
				System.exit(0);
				break;
			
			}
		}
	}

}

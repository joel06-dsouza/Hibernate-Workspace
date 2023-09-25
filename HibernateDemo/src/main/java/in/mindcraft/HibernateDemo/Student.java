package in.mindcraft.HibernateDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {		// POJO
	
	
	@Id
	private int rollno;
	
	private String name;
	
	@ManyToMany
//	@ManyToMany(mappedBy = "student")
	private List<Laptop> list = new ArrayList<Laptop>();


	public List<Laptop> getList() {
		return list;
	}
	
	public void setList(List<Laptop> list) {
		this.list = list;
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

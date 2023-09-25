package in.mindcraft.HQLDemo;

import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mobiles")
public class MobilePhone {
	@Id
	private int mid;
	
	private String name;
	
	private double cost;
	
	
	
	public MobilePhone() {

	}



	public MobilePhone(int mid, String name, double cost) {
		this.mid = mid;
		this.name = name;
		this.cost = cost;
	}



	@Override
	public String toString() {
		return "\nMobile Id=" + mid + ",\nMobile Name=" + name + ",\nMobile cost=" + cost;
	}



	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}



	public void getDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Mobile Id, Mobile Name, Mobile Cost - ");
		this.mid = sc.nextInt();
		this.name = sc.next();
		this.cost = sc.nextDouble();
		
	}	
	
	
}

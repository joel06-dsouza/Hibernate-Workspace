package in.mindcraft.InheritanceDemo;

import javax.persistence.Entity;

@Entity
public class CurrentAccount extends Account{
	private double overlimit;

	public double getOverlimit() {
		return overlimit;
	}

	public void setOverlimit(double overlimit) {
		this.overlimit = overlimit;
	}
	
	
}

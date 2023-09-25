package in.mindcraft.InheritanceDemo;

import javax.persistence.Entity;

@Entity
public class SavingAccount extends Account{
	private int interestRate;

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
}

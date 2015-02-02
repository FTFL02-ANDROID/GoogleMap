package sam.limo.oopandroidproject;

public class Account {
	public String number;
	public String name;
	public double balance;
	
	public void withdraw(double amount)
	{
		balance -= amount;
	}
	
	public void deposit(double amount)
	{
		balance += amount;
	}
	
}


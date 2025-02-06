package entity;

public class BankAccount {
	private int id;
	private User holder;
	private double amount;
	private double maxWithDraw;
	
	public BankAccount() {}
	
	public BankAccount(User holder, double maxWithDraw) {
		super();
		this.id = (int) (Math.random() * 999) + 1;
		this.holder = holder;
		this.amount = 0;
		this.maxWithDraw = maxWithDraw;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getHolder() {
		return holder;
	}

	public void setHolder(User holder) {
		this.holder = holder;
	}

	public double getAmount() {
		return amount;
	}

	public boolean withdraw(double amount) {
		if(amount < 0)
			return false;
		
		if(amount < this.amount)
			return false;
		
		this.amount -= amount;
		return true;
	}
	
	public boolean deposit(double amount) {
		if(amount < 0)
			return false;

		this.amount += amount;
		return true;
	}

	public double getMaxWithDraw() {
		return maxWithDraw;
	}

	public void setMaxWithDraw(double maxWithDraw) {
		this.maxWithDraw = maxWithDraw;
	}

	@Override
	public boolean equals(Object obj) {
		
		var bk = (BankAccount) obj;
		
		return this.id == bk.id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: " + getHolder().getName();
	}
	
	
}

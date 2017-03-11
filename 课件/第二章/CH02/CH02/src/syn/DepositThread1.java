package syn;

public class DepositThread1 extends Thread
{
	//模拟用户账户
	private Account1 account;
	//当前取钱线程所希望存款的钱数
	private double depositAmount;

	public DepositThread1(String name , Account1 account , double depositAmount)
	{
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}

	public void run()
	{
			account.deposit(depositAmount);	
	}
}
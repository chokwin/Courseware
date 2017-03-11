package syn;
public class DrawThread1 extends Thread
{
	//模拟用户账户
	private Account1 account;
	//当前取钱线程所希望取的钱数
	private double drawAmount;

	public DrawThread1(String name , Account1 account , double drawAmount)
	{
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	public void run()
	{	
			account.draw(drawAmount);
	}
}
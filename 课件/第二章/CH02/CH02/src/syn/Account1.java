package syn;
//线程之间的协调运行 多个生产者对多个消费者
public class Account1
{
	private String accountNo;
	private double balance;
	//标识账户中是否已有存款的旗标
	private boolean flag = false;


	public Account1(){}

	public Account1(String accountNo , double balance)
	{
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}
	public String getAccountNo()
	{
		 return this.accountNo;
	}

	public double getBalance()
	{
		 return this.balance;
	}
	
	//取钱的方法
	public synchronized void draw(double drawAmount)
	{
		
		try
		{
			//如果flag为假，表明账户中还没有人存钱进去，则取钱方法阻塞
			while ((!flag)&&(balance<drawAmount))
			{
				System.out.println("draw wait begin");
				wait();
				System.out.println("draw wait end");
			}
				//执行取钱
				
				System.out.println(Thread.currentThread().getName() + 
					" 取钱:" +  drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为：" + balance);
				
				//将标识账户是否已有存款的旗标设为false。
				flag = false;
				//唤醒其他线程
				notifyAll();
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
	
	//存钱的方法
	public synchronized void deposit(double depositAmount)
	{
		
		try
		{
			//如果flag为真，表明账户中已有人存钱进去，则存钱方法阻塞
			while(flag)
			{
				System.out.println("deposit wait begin");
				wait();
				System.out.println("deposit wait end");
			}
				//执行存款
				
				System.out.println(Thread.currentThread().getName() + 
					" 存款:" +  depositAmount);
				balance += depositAmount;
				System.out.println("账户余额为：" + balance);
				//将表示账户是否已有存款的旗标设为true
				flag = true;
				//唤醒其他线程
				notifyAll();
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}

	
}
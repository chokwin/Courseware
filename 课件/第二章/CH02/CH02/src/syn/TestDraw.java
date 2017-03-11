package syn;
//一个生产者与一个消费者的测试程序
public class TestDraw
{
	public static void main(String[] args) 
	{
		//创建一个账户
		Account acct = new Account("1234567" , 0);
		
		new DepositThread("存款者甲" , acct , 800).start();
		new DrawThread("取钱者" , acct , 900).start();
		
	}
}
 
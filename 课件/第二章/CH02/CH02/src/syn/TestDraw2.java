package syn;
//一个生产者与多个消费者的测试程序  线程发生阻塞
public class TestDraw2
{
	public static void main(String[] args) throws InterruptedException
	{
		//创建一个账户
		Account1 acct = new Account1("1234567" , 0);
		for(int i=0;i<5;i++){
		  new DrawThread1("取钱者"+i , acct , 800).start();
		  
		}
		new DepositThread1("存款者甲" , acct , 800).start();
		
	   Thread.sleep(1000);
		Thread[] threadArray = new Thread[Thread.currentThread()
				.getThreadGroup().activeCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadArray);

		for (int i = 0; i < threadArray.length; i++) {
			System.out.println(threadArray[i].getName() + " "
					+ threadArray[i].getState());
		}
	}
}
 
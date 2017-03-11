
import java.util.concurrent.*;

//实现Runnable接口来定义一个简单的
class TestThread implements Runnable
{
	public void run()
	{
		for (int i = 0; i < 10 ; i++ )
		{
			System.out.println(Thread.currentThread().getName()
				+ "的i值为:" + i);
		}
	}
}

public class ThreadPoolTest
{
	public static void main(String[] args) 
	{
		//创建一个具有固定线程数（6）的线程池
		ExecutorService pool = Executors.newFixedThreadPool(6);
		//向线程池中提交3个线程
		pool.execute(new TestThread());
		Future f1=pool.submit(new TestThread());
		Future f2=pool.submit(new TestThread());
		
	    Future<Integer> f3=pool.submit(new  RtnThread());
		
		try
		{
			if(f1.get()==null&&f2.get()==null&&f3.get()!=null){
				System.out.println("执行完毕！");
				System.out.println(f3.get());
				
			}
			//获取线程返回值
								
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		//关闭线程池
		pool.shutdown();
	}
}

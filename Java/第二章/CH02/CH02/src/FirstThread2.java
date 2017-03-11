
//通过继承Thread类来创建线程类
public class FirstThread2 extends Thread
{
	private int i = 10 ;
	//重写run方法，run方法的方法体就是线程执行体
	public void run()
	{

	  while(i>0)	{
		i--; 
		try{
				Thread.sleep(1000);
			 }catch(Exception e){
				 e.printStackTrace();
			}
		System.out.println(Thread.currentThread().getName() +  " " + i);
	}
	}
	
    public static void main(String[] args) 
    {
    	  
		 for (int i = 0; i < 50;  i++)
		  {
			System.out.println(Thread.currentThread().getName() +  " " + i);
				if (i == 20)
				{ 
				  FirstThread2 t=new FirstThread2();
				  new Thread(t,"A").start();
			      new Thread(t,"B").start();
		       }
		    }
    }  
}
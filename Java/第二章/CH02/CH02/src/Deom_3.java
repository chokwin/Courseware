//请编写一个程序，该程序可以接受一个整数n，
///创建个线程，一个线程计算从1+........+n并输出结果
//另一个线程每隔一秒再控制台输出“我是一个线程，正在输入第**个hello,world！”这两个工作要同时进行。


public class Deom_3 {
	public static void main(String[] args){
		FThread t1=new FThread(10);
		SThread t2=new SThread(10);
		new Thread(t1).start();
		new Thread(t2).start();
	}

}

class FThread implements Runnable{
	private int n=0;
	private int result=0;
	private int times=0;
	public FThread(int n){
		this.n=n;
	}
	public void run(){
	   while(true){
		 try{
			Thread.sleep(1000);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	   result+=(++times);
	   System.out.println("当前结果是: "+result);
	   if(times==n){
		 System.out.println("最后结果是: "+result);   
		 break;
	   }
	}
   }	
}
class SThread implements Runnable{
	private int n=0;
	private int times=0;
	public SThread(int n){
		this.n=n;
	}
	public void run(){
	   while(true){
		 try{
			Thread.sleep(1000);
		 }catch(Exception e){
			 e.printStackTrace();
		 }	
		 times++;
		 System.out.println("我是一个线程，正在输出"+times+"次 Hello World！");
		 if(times==n) break;
   }	
  }
}
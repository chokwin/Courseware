//继承Thread类的线程
//该程序每隔一秒在控制台输出“Hello  World!”

public class Deom_1 extends Thread{
	
	public void run(){
		while(true){
			try{
			  Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
		   }
			System.out.println(Thread.currentThread().getName()+" :Hello World！");
			
		}
	}
	
	public static void main(String[] args){
		System.out.println("当前线程的名字:"+Thread.currentThread().getName());
		Deom_1  demo=new Deom_1();
		demo.setName("ThreadA");
		demo.start();
	}

}

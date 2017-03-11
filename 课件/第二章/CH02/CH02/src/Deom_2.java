//实现Runnalbe接口的线程
//编写一个程序，该程序每隔一秒在控制台输出“Hello  World!”.当输入十次后自动退出。

public class Deom_2 implements Runnable{
	private int time;
	public void run(){
		while(true){
			try{
			  Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("Hello World！");
			time++;
			if(time==10) break;
		}
	}
	
	public static void main(String[] args){
		Deom_2  demo_2=new Deom_2();
		Thread t1=new  Thread(demo_2);
		t1.start();
	}

}

//买票系统

public class Demo_4 {

	public static void main(String[] args) {
/*
		TicketWindow2 t1=new TicketWindow2();
		TicketWindow2 t2=new TicketWindow2();
		TicketWindow2 t3=new TicketWindow2();
		t1.start();
		t2.start();
		t3.start();*/
	
	/*
	    TicketWindow t1=new TicketWindow();
	  
	    TicketWindow t2=new TicketWindow();

	    TicketWindow t3=new TicketWindow();
	    
	    new Thread(t1).start();
	    new Thread(t2).start();
	    new Thread(t3).start();
      */
	 
	 	TicketWindow t1=new TicketWindow();
		  
	 
	    
	    new Thread(t1).start();
	    new Thread(t1).start();
	    new Thread(t1).start();
		
	}

}

class TicketWindow implements  Runnable{
	
	private int num=50;
	public void run(){
		
		while(true){
	    //出票的速度是一秒出一张
		 try{
			 Thread.sleep(1000);
		 }catch(Exception e){
			e.printStackTrace(); 
		 }
		//先判断是否有票
	synchronized(this){
		if(num>0){
			System.out.println(Thread.currentThread().getName()
					+"正在出售第"+num+"张票！");
			num--;
		}else{
			System.out.println("票已经买完了");
			break;
		}
	}	
	}
   }
}
/*
class TicketWindow2 extends  Thread{
	
	private int num=50;
	public void run(){
		
		while(true){
	    //出票的速度是一秒出一张
		 try{
			 Thread.sleep(1000);
		 }catch(Exception e){
			e.printStackTrace(); 
		 }
		//先判断是否有票
		
		if(num>0){
			System.out.println(Thread.currentThread().getName()
					+"正在出售第"+num+"张票！");
			num--;
		}else{
			System.out.println("票已经买完了");
			break;
		}
		
	}
   }
}*/
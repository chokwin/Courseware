package PCTest.OneToOne;
//生产者
public class P {
	private String lock;
	public P(String lock){this.lock=lock;}
	
	public void setValue(){
	  try{	
	    synchronized(lock){	
		if(!ValueObject.value.equals("")){
			lock.wait();
		}
		String value = System.currentTimeMillis() + "_"+ System.nanoTime();
		System.out.println("set的值是" + value);
		ValueObject.value = value;
		lock.notify();
	   }
	}catch(InterruptedException e){ e.printStackTrace();}
	}
}

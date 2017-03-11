
public class RunThreadLocal {
	
	public static ThreadLocal<String> t1=new ThreadLocal<String>();
	
	public static void main(String[] args){
		if(t1.get()==null){
			System.out.println("从未放过值");
			t1.set("我的值");
		}
	System.out.println(t1.get());
	}
}

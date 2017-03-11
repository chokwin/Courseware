package syn;

public class Test1 {

	public static void main(String[] args) {
		try{
			//调用wait方法没有持有适当的锁会抛出异常
			String newString=new String("test");
			newString.wait();
		}catch(InterruptedException e){
			e.printStackTrace();
		}

	}

}

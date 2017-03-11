package syn;

public class Test2 {

	public static void main(String[] args) {
		try{
			
			String newString=new String("test");
			System.out.println("syn上面");
			synchronized(newString){
				System.out.println("syn第一行");
				newString.wait();
				//线程没有被唤醒永远处于等待状态
				System.out.println("wait下面的代码");
			}
			System.out.println("syn下面的代码");
		}catch(InterruptedException e){
			e.printStackTrace();
		}

	}

}

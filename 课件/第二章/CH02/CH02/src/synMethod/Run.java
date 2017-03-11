package synMethod;
//访问方法中的变量
public class Run {
	public static void main(String[] args) {
		MyObject object = new MyObject();
		ThreadA2 a = new ThreadA2(object);
		a.setName("A");
		ThreadB2 b = new ThreadB2(object);
		b.setName("B");

		a.start();
		b.start();

	}

}
class MyObject {

	synchronized public void methodA() {
		try {
			System.out.println("begin methodA threadName="
					+ Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class ThreadA2 extends Thread {

	private MyObject object;

	public ThreadA2(MyObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodA();
	}

}

class ThreadB2 extends Thread {

	private MyObject object;

	public ThreadB2(MyObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodA();
	}
}

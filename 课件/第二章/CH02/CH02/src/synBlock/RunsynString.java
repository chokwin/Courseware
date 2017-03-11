package synBlock;

public class RunsynString {

		public static void main(String[] args) {
			Service1 service = new Service1();

			ThreadAA a = new ThreadAA(service);
			a.setName("A");
			a.start();

			ThreadBB b = new ThreadBB(service);
			b.setName("B");
			b.start();

		}

}


class Service1 {

	private String anyString = new String();

	public void a() {
		try {
			synchronized (anyString) {
				System.out.println("a begin");
				Thread.sleep(3000);
				System.out.println("a   end");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized public void b() {
		try {	
		System.out.println("b begin");
		System.out.println("b   end");
		Thread.sleep(3000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class ThreadAA extends Thread {
	private Service1 service;

	public ThreadAA(Service1 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.a();

	}
}
class ThreadBB extends Thread {

	private Service1 service;

	public ThreadBB(Service1 service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.b();

	}

}
package syn;

public class Test3 {
    //main方法中有三个等待线程，一个唤醒线程，一个唤醒线程只能唤醒一个等待线程，程序出现阻塞
	public static void main(String[] args) throws InterruptedException {

		Object lock = new Object();

		ThreadA a = new ThreadA(lock);
		new ThreadA(lock).start();
		new ThreadA(lock).start();
		new ThreadA(lock).start();

		Thread.sleep(1000);

		NotifyThread notifyThread = new NotifyThread(lock);
		notifyThread.start();

	}

}

class ThreadA extends Thread {
	private Object lock;

	public ThreadA(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		Service service = new Service();
		service.testMethod(lock);
	}

}

class NotifyThread extends Thread {
	private Object lock;

	public NotifyThread(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			//notify()只能唤醒一个线程，nofiyAll()唤醒所有的等待线程
			lock.notify();
			//lock.notifyAll();
		}
	}

}

class Service {

	public void testMethod(Object lock) {
		try {
			synchronized (lock) {
				System.out.println("begin wait() ThreadName="
						+ Thread.currentThread().getName());
				lock.wait();
				System.out.println("  end wait() ThreadName="
						+ Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}



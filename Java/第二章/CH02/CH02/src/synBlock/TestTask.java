package synBlock;

public class TestTask {


	public static void main(String[] args) {
		Task task = new Task();
       //启动线程1
		new MyThread(task).start();
       //启动线程2
		new MyThread(task).start();

	}

}

class Task {

	public void doLongTimeTask() {
		for (int i = 0; i < 50; i++) {
			System.out.println("nosynchronized threadName="
					+ Thread.currentThread().getName() + " i=" + (i + 1));
		}
		System.out.println("");
		synchronized (this) {
			for (int i = 0; i < 20; i++) {
				System.out.println("synchronized threadName="
						+ Thread.currentThread().getName() + " i=" + (i + 1));
			}
		}

	}
}

class MyThread extends Thread {

	private Task task;

	public MyThread(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		task.doLongTimeTask();
	}

}

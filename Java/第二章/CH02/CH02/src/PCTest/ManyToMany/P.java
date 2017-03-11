package PCTest.ManyToMany;

//生产者
public class P {

	private String lock;

	public P(String lock) {
		super();
		this.lock = lock;
	}

	public void setValue() {
		try {
			synchronized (lock) {
				//修改wait条件
				while (!ValueObject.value.equals("")) {
					System.out.println("生产者"
							+ Thread.currentThread().getName() + " WAITING**");
					lock.wait();
				}
				System.out.println("生产者" + Thread.currentThread().getName()
						+ " RUNNABLE%%");
				String value = System.currentTimeMillis() + "_"
						+ System.nanoTime();
				ValueObject.value = value;
				lock.notify();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

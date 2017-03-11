package PCTest.ManyToMany;
//消费者
public class C {

	private String lock;

	public C(String lock) {
		super();
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				//修改wait条件
				while (ValueObject.value.equals("")) {
					System.out.println("消费者"
							+ Thread.currentThread().getName() + " WAITING**");
					lock.wait();
				}
				System.out.println("消费者" + Thread.currentThread().getName()
						+ " RUNNABLE%%");
				ValueObject.value = "";
				lock.notify();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

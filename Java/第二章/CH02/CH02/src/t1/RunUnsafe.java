package t1;

 class SelfPrivateNum {
    private int num =0;
	public void addI(String username) {
		try {
			
			if (username.equals("a")) {
				num = 100;
				System.out.println("a set over!");
				Thread.sleep(2000);
			} else {
				num = 200;
				System.out.println("b set over!");
			}
			System.out.println(username + " num=" + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
 
 class ThreadAA extends Thread {

		private SelfPrivateNum numRef;

		public ThreadAA(SelfPrivateNum numRef) {
			super();
			this.numRef = numRef;
		}

		@Override
		public void run() {
			super.run();
			numRef.addI("a");
		}

	}
 class ThreadBB extends Thread {

		private SelfPrivateNum numRef;

		public ThreadBB(SelfPrivateNum numRef) {
			super();
			this.numRef = numRef;
		}

		@Override
		public void run() {
			super.run();
			numRef.addI("b");
		}

	}
 
public class RunUnsafe {

	public static void main(String[] args) {

		SelfPrivateNum numRef = new SelfPrivateNum();

		ThreadAA athread = new ThreadAA(numRef);
		athread.start();

		ThreadBB bthread = new ThreadBB(numRef);
		bthread.start();

	}

}

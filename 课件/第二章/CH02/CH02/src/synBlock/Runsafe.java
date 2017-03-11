package synBlock;

 class SelfPrivateNum2 {
    private int num =0;
	public  void addI(String username) {
		synchronized(this){
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
 
 class ThreadAA2 extends Thread {

		private SelfPrivateNum2 numRef;

		public ThreadAA2(SelfPrivateNum2 numRef) {
			super();
			this.numRef = numRef;
		}

		@Override
		public void run() {
			super.run();
			numRef.addI("a");
		}

	}
 class ThreadBB2 extends Thread {

		private SelfPrivateNum2 numRef;

		public ThreadBB2(SelfPrivateNum2 numRef) {
			super();
			this.numRef = numRef;
		}

		@Override
		public void run() {
			super.run();
			numRef.addI("b");
		}

	}
 
public class Runsafe {

	public static void main(String[] args) {

		SelfPrivateNum2 numRef = new SelfPrivateNum2();

		ThreadAA2 athread = new ThreadAA2(numRef);
		athread.start();

		ThreadBB2 bthread = new ThreadBB2(numRef);
		bthread.start();

	}

}

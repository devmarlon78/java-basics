/*class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("Runnable");
	}
}

class A {
	public static void main(String[] args) {
		MyRunnable m = new MyRunnable();
		Thread t = new Thread(m);
		t.start();
	}
}*/


class B {
	synchronized void m() {
		System.out.println("m");
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("m is interrupted");
		}
	}

	synchronized void n() {
		System.out.println("n");
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("n is interrupted");
		}
	}
}

class NewThread extends Thread {
	private B r;

	public NewThread(B r) {
		this.r = r;
	}

	@Override
	public void run() {
		while(true) {
			this.r.m();
		}
	}
}

class OtherThread extends Thread {
	private B r;

	public OtherThread(B r) {
		this.r = r;
	}

	@Override
	public void run() {
		this.r.n();
	}
}

class A {
	public static void main(String[] args) {
		B b = new B();
		new NewThread(b).start();
		new OtherThread(b).start();
	}
}
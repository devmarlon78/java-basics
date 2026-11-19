class MyRunnable implements Runnable {
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
}
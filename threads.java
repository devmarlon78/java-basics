/*class A extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		A a = new A();
		a.setName("AA");
		a.start();
	}
} */

/*class A {
	public static void main(String[] args) {
		System.out.println("Before sleep");

		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {

		}

		System.out.println("After Sleep");
	}
}*/


class A {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();

		System.out.println("Current Thread: " + t);
		t.setName("My Thread");
		System.out.println("After Name: " + t);

		for(int i = 0; i < 10; i++) {
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Main Thread interrupted");
			}
		}
	}
}
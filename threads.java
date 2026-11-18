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

class A {
	public static void main(String[] args) {
		System.out.println("Before sleep");

		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {

		}

		System.out.println("After Sleep");
	}
}
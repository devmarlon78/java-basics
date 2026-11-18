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


/*class A {
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
}*/


/*class MyThread extends Thread {
	@Override 
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted" + e);
			}
		}
	}
}

class A {
	public static void main(String[] args) {
		MyThread m = new MyThread();
		m.start();

		for(int i = 10; i < 20; i++) {
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Main Thread interrupted" + e);
			}
		}
	}
}*/


/*class NewThread extends Thread {
	public NewThread() {
		System.out.println("Child Thread");
		this.start();
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Child Thread: " + i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Child Thread interrupted: " + e);
			}
		}
	}
}

class A {
	public static void main(String[] args) {
		new NewThread();

		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread: " + i);
		}

		System.out.println("Main Thread Exiting");
	}
}*/


/*class NewThread extends Thread {
	public NewThread(String name) {
		this.setName(name);
		this.start();
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.getName() + " " + i);
			if(i % 2 == 0) {
				Thread.yield();
			}
		}
		System.out.println(this.getName() + " is exited");
	}
}

class A {
	public static void main(String[] args) {
		new NewThread("One");
		new NewThread("Two");
		new NewThread("Three");
	}
}*/


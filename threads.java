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

/*class NewThread extends Thread {
	public NewThread(String name, int priority) {
		super(name);
		this.setPriority(priority);
		this.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName() + " : " + i);
		}
	}
}

class A {
	public static void main(String[] args) {
		new NewThread("One", Thread.MIN_PRIORITY);
		new NewThread("Two", 5);
		new NewThread("Three", Thread.MAX_PRIORITY);
	}
}*/


/*class NewThread extends Thread {
	public NewThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.getName() + " : " + i);
			if(i == 5) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println(this.getName() + " is interrupted: " + e);
				}
			}
		}

		System.out.println(this.getName() + " is exited");
	}
}

class A {
	public static void main(String[] args) {
		NewThread t1 = new NewThread("One");
		t1.start();
		System.out.println("Thread One: " + t1.isAlive());
		try {
			t1.join(1000);
		} catch (InterruptedException e) {
			System.out.println("Main Thread is interrupted");
		}
	}
}*/



class B {
	synchronized public void printName(String name) {
		System.out.println("[ ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Thread: " + name + " is interrupted");
		}
		System.out.println(name + " ]");
	}
}

class NewThread extends Thread {
	private B r;
	public NewThread(String name, B r) {
		super(name);
		this.r = r;
	}

	@Override
	public void run() {
		r.printName(this.getName());
	}
}

class OtherThread extends Thread {
	private B r;
	public OtherThread(String name, B r) {
		super(name);
		this.r = r;
	}

	@Override
	public void run() {
		this.r.printName(this.getName());
	}
}

class A {
	public static void main(String[] args) {
		B b = new B();
		B c = new B();
		NewThread t1 = new NewThread("One", b);
		OtherThread t2 = new OtherThread("Two", c);
		t1.start();
		t2.start();
	}
}
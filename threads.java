class A extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		A a = new A();
		a.setName("AA");
		a.start();
	}
}
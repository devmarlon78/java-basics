class A {
	{
		System.out.println("Block A");
	}

	static {
		System.out.println("Static Block A");
	}

	public A() {
		System.out.println("Constructor A");
	}

	public static void main(String[] args) {
		System.out.println("main");
		A a = new A();
	}
}
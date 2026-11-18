class A {
	public A() {
		System.out.println("Class A");
	}
}

class B extends A {
	public B() {
		System.out.println("Class B");
	}
}

class Overloading {
	public static void main(String[] args) {
		A a = new A();
		System.out.println("======");
		B b = new B();
		System.out.println("=======");
		A c = new B();
	}
}
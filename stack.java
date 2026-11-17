interface IntStack {
	public static final int TOS = -1;
	public abstract void push(int item);
	public abstract int pop();
}

class FixedStack implements IntStack {
	private int stackArr[];
	private int tos;

    public FixedStack(int size) {
		this.stackArr = new int[size];
		this.tos = TOS;
    }

	@Override 
	public void push(int item) {
		if(tos == this.stackArr.length - 1) {
			System.out.println("Your stack is full");
		}
		else {
			this.stackArr[++this.tos] = item;
		}
	}

	@Override 
	public int pop() {
		if(this.tos < 0) {
			System.out.println("Your stack is underflow");
			return 0;
		}
		return this.stackArr[this.tos--];
	}
	
}


public class stack {
	public static void main(String[] args) {
		FixedStack fixedStackArr = new FixedStack(10);

		for (int i = 0; i < 10; i++) {
			fixedStackArr.push(i);
		}

		for(int j = 0; j < 10; j++) {
			System.out.println(fixedStackArr.pop());
		}
	}
}

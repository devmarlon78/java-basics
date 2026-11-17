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

class DynamicStack implements IntStack {
	private int tos;
	private int size;
	private int stackArr[];

	public DynamicStack(int size) {
		this.tos = TOS;
		this.size = size;
		this.stackArr = new int[this.size];
	}

	@Override 
	public void push(int item) {
		if(this.tos == this.size - 1) {
			int tempArr[] = new int[this.size];
			for(int i = 0; i < this.size; i++) {
				tempArr[i] = this.stackArr[i];
			}
			this.stackArr = new int[this.size * 2];
			this.size = this.size * 2;
			for(int i = 0; i < tempArr.length; i++) {
				this.stackArr[i] = tempArr[i];
			}
			this.stackArr[++this.tos] = item;
		}
		else {
			this.stackArr[++tos] = item;
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
		DynamicStack fixedStackArr = new DynamicStack(10);

		for (int i = 0; i < 20; i++) {
			fixedStackArr.push(i);
		}

		for(int j = 0; j < 20; j++) {
			System.out.println(fixedStackArr.pop());
		}
	}
}

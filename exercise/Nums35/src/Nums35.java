class Stack {
	private int data[];
	private int elementCount = -1;
	private static final double DEFAOULT_LOAD_FACTOR = 1.5;
	private static final int DEFAOULT_SIZE = 10;

	
	
	public Stack() {
		this(DEFAOULT_SIZE);
	}

	Stack(int i) {
		data = new int[i];
	}

	void push(int element) {
		elementCount++;
		if (elementCount < data.length) {
			data[elementCount] = element;
		} else {
			int dataNew[] = new int[(int) (data.length * DEFAOULT_LOAD_FACTOR)];
			for (int i = 0; i < data.length; i++) {
				dataNew[i] = data[i];
			}
			data = dataNew;
			data[elementCount] = element;
		}
	}

	int pop() {
		if (elementCount != -1) {
			int lastElement = data[elementCount];
			elementCount--;
			System.out.println("Last element pop(), he is = " + lastElement);
			return lastElement;
		} else {
			System.out
					.println("pop() not work! Stack is empty!!! Add elements");
			return -1;
		}
	}

	void clearArray() {
		data = new int[10];
		elementCount = -1;
		System.out.println("Stack is clear");
	}

	void display() {
		System.out.print("Stack: ");
		if (elementCount != -1) {
			for (int i = elementCount; i > -1; i--) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		} else {
			System.out
					.println("display() not work! Stack is empty!!! Add elements");
		}
	}

	void sizeArray() {
		System.out.println("Size stack is: " + data.length);
	}
}

public class Nums35 {
	public static void main(String args[]) {
		Stack s = new Stack(10);
		s.sizeArray();
		for (int i = 0; i < 10; i++) {
			s.push(i);
		}
		s.display();

		for (int i = 0; i < 10; i++) {
			s.push(i);
		}
		s.display();

		s.sizeArray();
		s.pop();
		s.display();

		s.clearArray();
		s.sizeArray();
		s.pop();
		s.display();

	}

}

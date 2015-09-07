class Stack<T> {
	private T data[];
	private int elementCount = -1;
	private static final double DEFAOULT_LOAD_FACTOR = 1.5;
	private static final int DEFAOULT_SIZE = 10;

	public Stack() {
		this(DEFAOULT_SIZE);
	}

	Stack(int i) {
		data = (T[]) new Object[i];
	}

	void push(T element) {
		elementCount++;
		if (elementCount < data.length) {
			data[elementCount] = element;
		} else {
			loadArray();
			data[elementCount] = element;
		}
	}

	T pop() {
		if (elementCount != -1) {
			T lastElement = data[elementCount];
			elementCount--;
			System.out.println("Last element pop(), he is = " + lastElement);
			return lastElement;
		} else {
			System.out
					.println("pop() not work! Stack is empty!!! Add elements");
			T a = null;
			return a;
		}
	}

	void clearArray() {
		data = (T[]) new Object[DEFAOULT_SIZE];
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

	private void loadArray() {
		T dataNew[] = (T[]) new Object[(int) (data.length * DEFAOULT_LOAD_FACTOR)];
		for (int i = 0; i < data.length; i++) {
			dataNew[i] = data[i];
		}
		data = dataNew;
	}
}

public class Nums35 {
	public static void main(String args[]) {
		Stack<Integer> s = new Stack<Integer>(10);
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

		Stack<String> s1 = new Stack<String>(10);
		s1.push("Один");
		s1.push("Два");
		s1.push("Три");
		s1.push("Чотири");
		s1.push("Пять");
		s1.display();

	}

}
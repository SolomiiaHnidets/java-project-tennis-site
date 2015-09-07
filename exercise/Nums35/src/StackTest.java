import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackTest {

	private Stack<Integer> stack;

	public void setUp() {
		stack = new Stack<>();
	}

	@Test
	public void pushTest() {
		Integer element = 10;
		stack.push(element);
		assertEquals(element, stack.pop());
	}

}

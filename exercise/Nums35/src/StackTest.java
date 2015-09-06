import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

	private Stack stack;

	@Before
	public void setUp() {
		stack = new Stack();
	}
	
	@Test
	public void shouldAddsElement() {
		int element = 10;
		stack.push(element);
		assertEquals(element, stack.pop());
	}

	@Test
	public void test() {
//		fail("Not yet implemented");
	}

}

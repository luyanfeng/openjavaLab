package test.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTest {
	
	@Test
	public void testList(){
		List<String> a = new ArrayList<>();
		a.add("a");
		a.add("b");
		a.add(0, "c");
		System.out.println(a);
		a.set(0, "d");
		System.out.println(a);
	}

}

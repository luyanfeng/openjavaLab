package test.junit;

import java.util.TreeSet;

import org.junit.Test;

public class TreeSetTest {
	
	@Test
	public void testTreeSet(){
		TreeSet<String> s = new TreeSet<>();
		System.out.println(s.add("a"));
		System.out.println(s.add("a"));
		System.out.println(s.add("a"));
		System.out.println(s);
	}

}

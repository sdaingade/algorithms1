package algos;

import algos.impl.LinkedStack;

public class LinkdStackofStrings {
	public static void main(String[] args) throws Exception{
		LinkedStack<String> stack = new LinkedStack<String>();
		
		String[] items = {"too", "-", "be",  "or",  "not",  "to",  "be"};
		
		for (String item: items) {
			if(item.compareTo("-") == 0)
				System.out.println(stack.pop());
			else
				stack.push(item);
		}
	}
}
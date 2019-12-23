package algos;

import algos.impl.ResizingArrayStack;

public class ResizableStackOfString {
	public static void main(String[] args) throws Exception {
		ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
		
		String[] items = {"to", "be" , "or", "not", "to", "-","be", "-", "-", "that", "-", "-", "-", "is"};
		
		for(String item: items)
			if (item.compareTo("-") == 0)
				System.out.println(String.format("Popped; %s",stack.pop()));
			else
				stack.push(item);
	}
}
package algos;

import algos.iface.*;
import algos.impl.*;

public class ArithmeticExpressionEvaluation {

	public static void main(String[] args) throws Exception {
		Stack<String> operators = new ResizingArrayStack<String>();
		Stack<Double> operands = new ResizingArrayStack<Double>();

		String expr = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"; //101.0
		
		String[] items = expr.split(" ");
		for (String item: items ) {
			if (item.equals("("));
			else if (item.equals("+"))
				operators.push(item);
			else if (item.equals("*"))
				operators.push(item);
			else if (item.equals(")")) {
				Double op1 = operands.pop();
				Double op2 = operands.pop();
				String operator  = operators.pop();
				if (operator.equals("*"))
					operands.push(op1 * op2);
				else
					operands.push(op1 + op2);
			} else operands.push(Double.parseDouble(item));
		}
		
		System.out.println(operands.pop());

	}
}
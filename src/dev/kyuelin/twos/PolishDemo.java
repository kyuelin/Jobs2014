package dev.kyuelin.twos;

public class PolishDemo {
	
	private static class OperatorFactory {
		private static Map<String, Operator> opMap = new HashMap<String, Operator>();

		
		static Operator findOp(String c) {
			return opMap.get(c); 
		}
		
		static void registerOp(String c, Operator op) {
			if (!opMap.containsKey(c)) {
				opMap.put(c,  op);
			}
		}
		
	}
	
	interface Operator {
		double operate(List<Double> operands);
	}
	
	private static class PlusOperator implements Operator {

		@Override
		public double operate(List<Double> operands) {
			double result = 0;
			
			for(double d: operands) {
				result += d;
			}
			return result;
		}
	}
	
	
	private static class MulOperator implements Operator {

		@Override
		public double operate(List<Double> operands) {
			double result = 1;
			
			for(double d: operands) {
				result *= d;
			}
			return result;
		}
	}
	
	private static boolean checkNum(String s) {
		try {
			Integer.valueOf(s);			
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] input = {"2", "2", "+", "3", "*"};
		
		OperatorFactory.registerOp("+", new PlusOperator());
		OperatorFactory.registerOp("*", new MulOperator());

		Stack<String> sk;
		sk = new Stack<String>();

		for(String s : input) {
			if (checkNum(s)) {
				sk.add(s);
			} else {
				ArrayList<Double> ld = new ArrayList<>();
				while (!sk.isEmpty()) {
					ld.add(Double.valueOf(sk.pop()));
				}

				Operator op = OperatorFactory.findOp(s);
				sk.push(String.valueOf(op.operate(ld)));
			}
		}
		System.out.println(sk.pop());
	}
}

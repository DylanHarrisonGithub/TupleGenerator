
public class Main {

	public static void main(String[] args) {

		RecursiveIntTupleGenerator fourTuple = new RecursiveIntTupleGenerator(4);
		boolean solutionFound;
		int a,b,c,d;
		
		for (int i = 0; i < 100; i++) {
			
			fourTuple.setZero();
			solutionFound = false;
			
			while (!solutionFound) {
				
				a = fourTuple.getVal(0);
				b = fourTuple.getVal(1);
				c = fourTuple.getVal(2);
				d = fourTuple.getVal(3);
				
				if ((a*a+b*b+c*c+d*d) == i) {
					System.out.println(Integer.toString(i) + ": (" + fourTuple.toString() + ")");
					solutionFound = true;
				}
				
				fourTuple.next();
				
			}
			
			
		}
		
	}

}

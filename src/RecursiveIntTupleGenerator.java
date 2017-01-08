
public class RecursiveIntTupleGenerator {

	private int x;
	private RecursiveIntTupleGenerator subTuple;
	private int dimensions;
	private int savedX;
	
	public RecursiveIntTupleGenerator(int numOfDimensions) {
		
		if (numOfDimensions < 2) {
			
			x = 0;
			dimensions = 1;
			
		} else {
			
			x = 0;
			dimensions = numOfDimensions;
			subTuple = new RecursiveIntTupleGenerator(numOfDimensions -1);
			
		}
		
	}
	
	public void next() {
		
		if (dimensions == 1) {
			
			x += 1;
						
		} else {
			
			if (x > 0) {
				
				x -= 1;
				subTuple.next();
				
			} else {
				
				savedX += 1;
				x = savedX;
				subTuple.setZero();
				
			}
			
		}
		
	}
	
	public int getDimensions() {
		
		return dimensions;
		
	}
	
	public void setZero() {
		
		x = 0;
		savedX = 0;
		
		if (subTuple != null) {
			
			subTuple.setZero();
			
		}
		
	}
	
	public int getVal(int index) { 
		
		if ((index > -1) && (index < dimensions)) {
			
			if (index == 0) {
				
				return x;
				
			} else {
				
				return subTuple.getVal(index - 1);
				
			}
			
		}
		
		return -1; 
	
	}
	
	public int[] toIntArray() { 

		if (subTuple != null) {
			
			return concatenate(new int[] {x}, subTuple.toIntArray());
			
		} else {
			
			return new int[] {x};
			
		}
	
	}
	
	private int[] concatenate(int[] a, int[] b) {
		
		int[] concatenated = new int[a.length+b.length];
		System.arraycopy(a, 0, concatenated, 0, a.length);
		System.arraycopy(b, 0, concatenated, a.length, b.length);
		
		return concatenated;
		
	}
	
	public String toString() { 

		if (subTuple != null) {
			
			return Integer.toString(x) + ", " + subTuple.toString();
			
		} else {
			
			return Integer.toString(x);
			
		}
		
	}
	
	public String toLaTeX() { 

		if (subTuple != null) {
			
			return Integer.toString(x) + "^{2} + " + subTuple.toLaTeX();
			
		} else {
			
			return Integer.toString(x) + "^{2}";
			
		}
		
	}
	
}

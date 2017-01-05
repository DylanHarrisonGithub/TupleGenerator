
public class RecursiveIntTupleGenerator {

	private int x;
	private RecursiveIntTupleGenerator v;
	private int dimensions;
	private int savedX;
	
	public RecursiveIntTupleGenerator(int numOfDimensions) {
		
		if (numOfDimensions < 2) {
			
			x = 0;
			dimensions = 1;
			
		} else {
			
			x = 0;
			dimensions = numOfDimensions;
			v = new RecursiveIntTupleGenerator(numOfDimensions -1);
			
		}
		
	}
	
	public int getDimensions() {
		
		return dimensions;
		
	}
	
	public void next() {
		
		if (v != null) {
			
			if (x > 0) {
				
				x -= 1;
				v.next();
				
			} else {
				
				savedX += 1;
				x = savedX;
				v.setZero();
				
			}
			
		} else {
			
			x += 1;
			
		}
		
	}
	
	public void prev() {}
	
	private boolean canDec() { 

		if (x > 0) {
			
			return true;
			
		} else {
			
			if (v != null) {
				
				return v.canDec();
				
			} else {
				
				return false;
				
			}
			
		}
		
	}
	
	public void setZero() {
		
		x = 0;
		savedX = 0;
		
		if (v != null) {
			
			v.setZero();
			
		}
		
	}
	
	public int getVal(int index) { 
		
		if ((index > -1) && (index < dimensions)) {
			
			if (index == 0) {
				
				return x;
				
			} else {
				
				return v.getVal(index - 1);
				
			}
			
		}
		
		return -1; 
	
	}
	
	public int[] toIntArray() { 

		if (v != null) {
			
			return concatenate(new int[] {x}, v.toIntArray());
			
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

		if (v != null) {
			
			return Integer.toString(x) + ", " + v.toString();
			
		} else {
			
			return Integer.toString(x);
			
		}
		
	}
	
	public String toLaTeX() { 

		if (v != null) {
			
			return Integer.toString(x) + " & " + v.toString();
			
		} else {
			
			return Integer.toString(x);
			
		}
		
	}
	
}

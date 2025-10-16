public class BooleanArrayIntSet implements IntSet {
  	private int size;   // Numero de elementos do conjunto
   	private boolean elem[]; // Array que contem os elementos em si 
	private int maxNum;
   	
   	BooleanArrayIntSet(int maxSize) {
   	   	elem = new boolean[maxSize];
		maxNum = maxSize;
   	   	size = 0;
   	}

   	public boolean add(int x) {
		if (this.elem[x-1]) return false;
		this.elem[x-1] = true;
		this.size++;
		return true;
   	}

   	public boolean remove(int x) {
		if (!this.elem[x-1]) return false;
		this.elem[x-1] = false;
		this.size--;
		return true;
   	}
   	
   	
   	public boolean contains(int x) {
		return this.elem[x-1];
   	}
   	
   	public void clear() {
		this.elem = new boolean[this.maxNum];
   	  	this.size = 0;
   	}
   	
   	public int size() {
   	   return size;
   	}

   	@Override 
   	public String toString() {
   	   String res = "{";
   	   for (int i=0; i<size; i++) {
   	      if (i>0) res += ",";
   	      res += elem[i];
   	   }
   	   res += "}";
   	   return res;
   	}

	public boolean equals(IntSet s) {
		if (s.size() != this.size()) return false;
                for (int i = 1; i <= this.maxNum; i++) {
                        if (s.contains(i) ^ this.contains(i)) return false;
                }
                return true;
	}

	public IntSet intersection(IntSet s) {
		IntSet result = new BooleanArrayIntSet(this.maxNum);
                for (int i = 1; i <= this.maxNum; i++) {
                        if (s.contains(i) && this.contains(i)) result.add(i);
                }
		return result;
	}
}

package poo.lecon04;

public class GarbageCollecting {
	public static void main(String[] args) {
		for(int i=0; i < Integer.MAX_VALUE; ++i) {
			StupidClass toBeCollected = new StupidClass(i);
		}
		
		System.err.println("Objects collected : "+StupidClass.objectCollected);
	}
	
//	public static void main(String[] args) {
//		DangerousClass last = new DangerousClass(-1, null);
//		
//		for(int i=0; i < Integer.MAX_VALUE; ++i) {
//			DangerousClass next = new DangerousClass(i, last);
//			last = next;
//			if(i%100_000 == 0) {
//				System.out.println(i+" objects created so far");
//			}
//		}
//		
//		System.err.println("Objects collected : "+StupidClass.objectCollected);
//	}
}

class StupidClass {
	public static int objectCollected = 0;
	private int someState;
	
	StupidClass(int someState) {
		this.someState = someState;
	}
	
	public void finalize() {
		++objectCollected;
		System.out.println(someState+" is being collected");
	}
}

class DangerousClass {
	public static int objectCollected = 0;
	private int someState;
	private DangerousClass previous;
	
	DangerousClass(int someState, DangerousClass previous) {
		this.someState = someState;
		this.previous = previous; 
	}
	
	public void finalize() {
		++objectCollected;
		System.out.println(someState+" is being collected");
	}
}


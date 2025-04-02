package lecon11;

public class IntLinkListDemo {
	
	public static void main(String[] args) {
		IntLinkList ill = new IntLinkList();
		
		ill.add(5);
		ill.add(1789);
		ill.add(-39);
		ill.add(235);
		System.out.println(ill); // (5, 1789, -39, 235)
		
		ill.add(42, 2); // attendu : (5, 1789, 42, -39, 235)
		System.out.println(ill.get(2)); // Devrait afficher 42
		
		ill.remove(3); 
		System.out.println(ill); // attendu : (5, 1789, 42, 235)
	}
}

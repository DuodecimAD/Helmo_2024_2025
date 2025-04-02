package lecon13.cake;

import java.util.List;

public class CoupeCakeDemo {

	public static void main(String[] args) {
		List<Integer> prix = List.of(0, 3,  7,  7,  8, 10, 
				                       11, 15, 15, 20, 22,
				                       26, 30, 35, 35, 40);
		CoupeCake cc = new RecCoupeCake(prix);
		CoupeCake cc2 = new DPCoupeCake(prix);
		
		for(int i = 1; i < prix.size(); ++i) {
			System.out.println("\nTaille = " + i);
			System.out.println("%35s | Gain maximal : %d".formatted(cc.descriptionMethode(), cc.coupe(i)));
			System.out.println("%35s | Gain maximal : %d".formatted(cc2.descriptionMethode(), cc2.coupe(i)));
		}
	}
}

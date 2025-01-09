package chap3;

public class Puzzle45 {

	public static void main(String[] args) {

		String string = "Un ordinateur peut entre autre effectuer des tâches répétitives sans se lasser et sans se tromper, "
				+ "enfin..., si le développeur a bien fait son travail.";
		
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == ',') {
				System.out.println(i);
				break;
			}
		}
		
		

	}

}

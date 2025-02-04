package chap13;

import java.util.Arrays;

public class cards {

	public static void main(String[] args) {
		
		
		
		String text = "D10 DQ H4 SK H8 HA C9 CQ H3 C4 S3 S2 S6 C5 S8 CK SJ HJ SQ DK D8 S9 H6 H2 D6 S5 H9 HK D4 D2 D5 S10 CJ DJ S4 C10 S7 C7 C6 H7 D9 SA H5 C8 HQ DA D7 D3 H10 C3 C2";
		String[] cards = text.split(" ");
		
		System.out.println(Arrays.toString(cards));
		
		Arrays.sort(cards);
		
		System.out.println(Arrays.toString(cards));

	}

}

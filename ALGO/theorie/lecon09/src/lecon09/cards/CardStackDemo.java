package lecon09.cards;

import io.Console;

public class CardStackDemo {

	public static final YGHCard[] KAIBA = {
			new YGHCard("Blue-Eyes White Dragon", Frame.NORMAL),
			new YGHCard("Obelisk the Tormentor", Frame.NORMAL),
			new YGHCard("Vorse Raider", Frame.NORMAL),
			new YGHCard("Battle Ox", Frame.NORMAL),
			new YGHCard("Hyozanryu", Frame.NORMAL),
			new YGHCard("Ryu Kishin Powered", Frame.NORMAL),
			new YGHCard("Saggi The Dark Clown", Frame.NORMAL),
			new YGHCard("La Jinn The Mystical Genie Of The Lamp", Frame.NORMAL),
			new YGHCard("Thunder Dragon", Frame.EFFECT),
			new YGHCard("Thunder Dragon", Frame.EFFECT),
			new YGHCard("Thunder Dragon", Frame.EFFECT),
			new YGHCard("Kaiser Sea Horse", Frame.EFFECT),
			new YGHCard("Kaiser Glider", Frame.EFFECT),
			new YGHCard("Lord of D.", Frame.EFFECT),
			new YGHCard("X-Head Cannon", Frame.NORMAL),
			new YGHCard("X-Head Cannon", Frame.NORMAL),
			new YGHCard("Y-Dragon Head", Frame.EFFECT),
			new YGHCard("Y-Dragon Head", Frame.EFFECT),
			new YGHCard("Z-Metal Tank", Frame.EFFECT),
			new YGHCard("Z-Metal Tank", Frame.EFFECT),
			new YGHCard("XYZ-Dragon Cannon", Frame.XYZ), // ;-)
			new YGHCard("XY-Dragon Cannon", Frame.FUSION),
			new YGHCard("Blue Eyes Ultimate Dragon", Frame.FUSION),
			new YGHCard("Polymerization", Frame.SPELL),
			new YGHCard("Polymerization", Frame.SPELL),
			new YGHCard("The Flute Of Summoning Dragon", Frame.SPELL),
			new YGHCard("The Flute Of Summoning Dragon", Frame.SPELL),
			new YGHCard("Shrink", Frame.SPELL),
			new YGHCard("Fiend's Sanctuary", Frame.SPELL),
			new YGHCard("Cost Down", Frame.SPELL),
			new YGHCard("Ring Of Defense", Frame.SPELL),
			new YGHCard("Monster Reborn", Frame.SPELL),
			new YGHCard("Soul Exchange", Frame.SPELL),
			new YGHCard("Silent Doom", Frame.SPELL),
			new YGHCard("Pot of Greed", Frame.SPELL),
			new YGHCard("Card Of Demise", Frame.SPELL),
			new YGHCard("Ennemy Controler", Frame.SPELL),
			new YGHCard("Crush Card Virus", Frame.TRAP),
			new YGHCard("Negate Attack", Frame.TRAP),
			new YGHCard("Ring Of Destruction", Frame.TRAP),
			new YGHCard("Final Attack Orders", Frame.TRAP),
			new YGHCard("Virus Cannon", Frame.TRAP),
			new YGHCard("Blue-Eyes White Dragon", Frame.NORMAL),
			new YGHCard("Blue-Eyes White Dragon", Frame.NORMAL)
	};
	
	public static void main(String[] args) {
		CardsStack stack = new CardsStack(KAIBA);
		
//		System.out.println(stack.getDeckList());
//		System.out.println();
//		
//		System.out.println(stack.getUniqueCardsList());
//		System.out.println();
		
		// Cette carte est interdite !
		// stack.remove(new YGHCard("Pot of Greed", Frame.SPELL));
		
		int nbCards = Console.lireInt("Combien souhaitez-vous de cartes ?");
		
//		stack.sort();
		stack.shuffle();
		
		for(var bc : stack.draw(nbCards)) {
			System.out.println(bc);
		}
	}
}

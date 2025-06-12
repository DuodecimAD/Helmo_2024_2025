package algo.labo04;

/**
 * Une Potence utilisée dans une partie de Pendu.
 * 
 * <p> Responsabilités :
 * 	<ul>
 * 		<li> Sait comment est dessinée une potence
 * 		<li> Connait son nombre d'étapes
 * 	</ul>
 */
public enum Potence {
	BOIS(Potence.STEP0),
	TETE(Potence.STEP1),
	CORPS(Potence.STEP2),
	BRAS(Potence.STEP3),
	JAMBE(Potence.STEP4),
	PENDU(Potence.STEP5);
	
	private static final String STEP0 = """
			 ┏━━━━━━┑
			 ┃	
			 ┃
			 ┃
			 ┃    
			 ┃    
			""";
	
	private static final String STEP1 = """
			 ┏━━━━━━┑
			 ┃      │
			 ┃      O
			 ┃
			 ┃    
			 ┃    
			""";
	
	private static final String STEP2 = """
			 ┏━━━━━━┑
			 ┃      │
			 ┃      O
			 ┃      █
			 ┃    
			 ┃    
			""";
	
	private static final String STEP3 = """
			 ┏━━━━━━┑
			 ┃      │
			 ┃      O
			 ┃     /█\\
			 ┃    
			 ┃    
			""";
	
	private static final String STEP4 = """
			 ┏━━━━━━┑
			 ┃      │
			 ┃      O
			 ┃     /█\\
			 ┃     / \\
			 ┃     ███
			""";
	
	private static final String STEP5 = """
			 ┏━━━━━━┑
			 ┃      │
			 ┃     \\O/
			 ┃      █
			 ┃     / \\
			 ┃     
			""";
	
	private final String representation;
	
	private Potence(final String rep) {
		representation = rep;
	}
	
	/**
	 * @return une image en ASCII-art de la potence.
	 */
	public String enImage() {
		return representation;
	}
	
	/**
	 * @return la Potence suivante dans le jeu Pendu
	 */
	public Potence suivante() {
		return switch(this) {
			case BOIS -> TETE;
			case TETE -> CORPS;
			case CORPS -> BRAS;
			case BRAS -> JAMBE;
			case JAMBE -> PENDU;
			/* N'arrivera jamais sauf en cas de (mauvaise) modification du code */
			default -> throw new IllegalArgumentException("Unexpected value: " + this);
		};
	}
}

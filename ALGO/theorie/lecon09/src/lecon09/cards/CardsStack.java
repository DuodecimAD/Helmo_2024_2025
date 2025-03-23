package lecon09.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringJoiner;

/**
 * CardsStack
 * @See CardsStack dans le syllabus de POO
 * @author Adapté du code de Nicolas Hendrikx
 */
public class CardsStack {
    private static final BaseCard[] DEFAULT_CARDS = new BaseCard[0];
    private List<YGHCard> cards = new ArrayList<>();
    private Map<YGHCard, Integer> deckCount = new HashMap<>();
    private Random random = new Random();

    //private int topPosition;

    public CardsStack(YGHCard...cards) {
    	if (cards != null) {
//    		for (int i = 0; i < cards.length; i++) {
//    			this.cards.add(cards[i]);
//    			addInCount(i, cards);
//			}	
    		
    		for (var card : cards) {
    			this.cards.add(card);
    			addInCount(card);
			}
    	}
    	
    }

	private void addInCount(YGHCard card) {
		int nbDejaPresent = deckCount.getOrDefault(card, 0);
		deckCount.put(card, nbDejaPresent + 1);
	}

    /**
     * Mélange la pile de carte
     */
    public void shuffle() {
    	Collections.shuffle(cards);
    }
    
    /**
     * Trie la pile de carte
     */
    public void sort() {
    	Collections.sort(cards);
    }
    
    public void remove(YGHCard card) {
    	if(cards.remove(card)) { // virer la cartesi présente
    		int nbOccurences = deckCount.get(card); // on vire de la map de tt facon
    		if(nbOccurences > 1) {
    			deckCount.put(card, nbOccurences - 1); // on le remet s'il ya plus d'un
    		}
    	}
    }
    
    public String getUniqueCardsList() {
    	// Série 2, exercice 2

    	StringJoiner sj = new StringJoiner("\n");
    	
//		mon code
//    	Iterator<YGHCard> it = deckCount.keySet().iterator();
//    	
//    	while(it.hasNext()) {
//    		sj.add(it.next().toString());
//    	}
    	
    	// code prof
    	for (BaseCard card : deckCount.keySet()) {
			sj.add(card.toString());
		}
  
	
    	return sj.toString();
    }
    
    public String getDeckList() {
    	// Série 2, exercice 2
    	
    	StringJoiner sj = new StringJoiner("\n");
    	
    	for (BaseCard card : cards) {
			sj.add(card.toString() + " : " + deckCount.get(card));
		}
    	
    	for (BaseCard card : cards) {
			sj.add(card.toString() + " : " + deckCount.get(card));
		}
    	
    	return sj.toString();
    }
    
    public boolean contains(BaseCard card) {
    	// Série 2, exercice 3
    	return deckCount.containsKey(card);
    }
    
    public void addAtRandomPosition(YGHCard card) {
    	// Série 2, exercice 3
    	int pos_insertion = random.nextInt(cards.size());
    	addInCount(card);
    	cards.addLast(card);
    	Collections.swap(cards,  pos_insertion,  cards.size() - 1);
    }
    
    /**
     * Pioche jusqu'à nbCards, dans les limites du stock dispo.
     * @param nbCards
     * @return
     */
    public List<YGHCard> draw(int nbCards) {
    	int toDraw = Math.clamp(nbCards, 0, cards.size());
    	
    	List<YGHCard> result = new ArrayList<>();
    	
    	// code prof
    	for (int i = 0; i < toDraw; ++i) {
    		var toRemove = cards.getLast();
			result.add(toRemove);
			remove(toRemove);
		}
    	
//    	mon code
//    	if(nbCards <= cards.size()) {
//    		for (int i = 0; i < nbCards; i++) {
//	    		YGHCard cardDrawn = cards.get((int) (Math.random()* cards.size()-1));
//				result.add(cardDrawn);
//				cards.remove(cardDrawn);
//    		}
//    	}
    	

    	return result;
    	
    	
    }
}
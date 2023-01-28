package pk;

import java.util.*;

public class CardDeck {
    private static ArrayList<Cards> cardDeck;

    // Constructor
    public CardDeck() {
        cardDeck = new ArrayList<Cards>();
        for(int i=0; i<2; i++) cardDeck.add(Cards.SEABATTLE300);
        for(int i=0; i<2; i++) cardDeck.add(Cards.SEABATTLE500);
        for(int i=0; i<2; i++) cardDeck.add(Cards.SEABATTLE1000);
        for(int i=0; i<3; i++) cardDeck.add(Cards.MB);
        for(int i=0; i<25; i++) cardDeck.add(Cards.NOP);
        Collections.shuffle(cardDeck);
    }

    public ArrayList<Cards> getShuffledDeck() {
        return cardDeck;
    }

    public Cards drawCard() {
        Cards card = cardDeck.get(0);
        cardDeck.remove(card);
        cardDeck.add(card);
        return card;
    }
}

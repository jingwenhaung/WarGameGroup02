import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initialDeck();
        shuffle();
    }

    // Initialize the deck with all possible combinations of suits and values
    public void initialDeck() {
        cards = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                cards.add(new Card(value, suit));
            }
        }
    }

    //shuffle the cards
    public void shuffle(){
        Collections.shuffle(cards);
    }

    // Get the number of cards in the deck
    public int getSize() {
        return cards.size();
    }

    // Remove and return the top card from the dec
    public Card removeCard() {
        return cards.remove(0);
    }
}

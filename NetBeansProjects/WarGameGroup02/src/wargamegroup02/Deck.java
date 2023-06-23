import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    //each deck create one cards
    public Deck(){
        cards = new ArrayList<>();
        for(Card.Suit suit: Card.Suit.values()){
            for(Card.Value value: Card.Value.values()){
                cards.add(new Card(value, suit));
            }
        }
    }

    //shuffle the cards
    public void shuffle(){
        Collections.shuffle(cards);
    }


    //player shows the card
    public Card showCard(){
        if(cards.isEmpty()){
            return null;
        }else{
            return cards.remove(cards.size() - 1);
        }
    }
}

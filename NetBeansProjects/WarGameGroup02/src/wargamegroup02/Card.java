public class Card {
    
    public enum Suit{
        HEARTS, CLUBS, SPADES, DIAMONDS
    }

    enum Value {
        // Card values for comparison
        ACE(14), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
        SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12),
        KING(13);

        private int value;

        private Value(int value) {
            this.value = value;
        }

         public int getValue() {
            return value;
        }
    }

    private Value value;
    private Suit suit;

    public Card(Value value, Suit suit){
        this.value = value;
        this.suit = suit;
    }


    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString(){
        return value + " of " + suit;
    }
}

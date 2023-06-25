import java.util.ArrayList;
import java.util.List;

public class Player{
    private String name;
    private int id;
    private List<Card> hand;
    private int scores;

    public Player(String name, int id){
        this.name = name;
        this.id = id;
        this.hand = new ArrayList<>();
        this.scores = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Card> getHand() {
        return hand;
    }
    public void setScores (int scores){
        this.scores = scores;
    }

    public int getScores() {
        return scores;
    }

    @Override
    public String toString(){
        return "name: " + this.name + "  ID: " + this.id + "  Scores: " +this.scores;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public Card showCard() {
        return hand.remove(0);
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }
}

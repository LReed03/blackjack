
import java.util.*;


public class Deck {
    private List<Card> cards = new ArrayList<>();

    
    public Deck(){
        this.initilizeDeck();
        this.shuffle();

    }
    
    public void initilizeDeck(){
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }


}

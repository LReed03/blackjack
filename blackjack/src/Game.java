import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Card> allCards = new ArrayList<>();

    public Game(int numberDecks){
        List<Deck> sumDeck = new ArrayList<>();
        for(int i = 0; i < numberDecks; i++){
                Deck deck = new Deck();
                for(int j = 0; i < 52; i++){
                    Card card = deck.getCard(j);
                    this.allCards.add(card);
                }
        }
        Collections.shuffle(sumDeck);
    }


    public int drawCard(){
        Random random = new Random();
        int randomIndex = random.nextInt(this.allCards.size());
        Card cardDrawn = this.allCards.get(randomIndex);
        return cardDrawn.getCardValue();
    }
}

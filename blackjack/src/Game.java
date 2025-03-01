import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game {
    private List<Card> allCards = new ArrayList<>();

    public Game(int numberDecks){
        List<Deck> sumDeck = new ArrayList<>();
        for(int i = 0; i < numberDecks; i++){
                Deck deck = new Deck();
                for(int j = 0; j < 52; j++){
                    Card card = deck.getCard(j);
                    this.allCards.add(card);
                }
        }
        Collections.shuffle(this.allCards);
    }


    public int drawCard(){
        Random random = new Random();
        int randomIndex = random.nextInt(this.allCards.size());
        Card cardDrawn = this.allCards.remove(randomIndex);
        cardDrawn.setCardValue(cardDrawn.getRank());
        int cardDrawnValue = cardDrawn.getCardValue();

        return cardDrawnValue;
    }

    public void dealer(){
        Player dealer = new Player();
        while(dealer.continueDraw()){
            int drawnCard = drawCard();
            dealer.increaseHand(drawnCard);
            System.out.print(dealer.getHand()+"\n");
            if(dealer.getHand() == 21){
                System.out.print("BLACKJACK!!!!");
            }
            if(dealer.getHand() > 21){
                System.out.print("Bust:(");
            }
        }
    }

    public void player(){
        Player player = new Player();
        boolean draw = true;
        int drawnCard = drawCard();
        player.increaseHand(drawnCard);
        System.out.print(player.getHand()+"\n");
        Scanner reader = new Scanner(System.in);
        while(draw){
            System.out.print("Would you like to hit or stand?\nSelect 0 for hit or 1 for stand  ");
            int n = reader.nextInt();
            if(n < 2 && n >= 0){
                boolean[] value = {true,false};
                draw = value[n];
                if(n == 1){
                    System.out.println("Break");
                    reader.close();
                    break;
                }
                int newDrawnCard = drawCard();
                player.increaseHand(newDrawnCard);
                int handValue = player.getHand();
                System.out.print("Your current hand value is \n"+handValue+"\n");
                }
            else{
                System.out.print("Select a valid index\n");
                continue;
            }
            if(player.getHand() > 21){
                System.out.println("Bust!\n");
                break;
            }
            if(player.getHand() == 21){
                System.out.println("BLACKJACK!\n");
                break;
            }
        }

        }
    }

    


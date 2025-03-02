import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private List<Card> allCards = new ArrayList<>();

    public Game(int numberDecks) {
        for (int i = 0; i < numberDecks; i++) {
            Deck deck = new Deck();
            for (int j = 0; j < 52; j++) {
                Card card = deck.getCard(j);
                this.allCards.add(card);
            }
        }
        Collections.shuffle(this.allCards);
    }

    public int drawCard() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.allCards.size());
        Card cardDrawn = this.allCards.remove(randomIndex);
        cardDrawn.setCardValue(cardDrawn.getRank());
        int cardDrawnValue = cardDrawn.getCardValue();

        return cardDrawnValue;
    }

    public int dealerDrawCard(Player dealer){
        Random random = new Random();
        int randomIndex = random.nextInt(this.allCards.size());
        Card cardDrawn = this.allCards.remove(randomIndex);
        if(cardDrawn.getRank() == Rank.ACE){
            if(dealer.getHand() < 11){
                return 11;
            }
            else{
                return 1;
            
        }
            }
        cardDrawn.setCardValue(cardDrawn.getRank());
        int cardDrawnValue = cardDrawn.getCardValue();
        return cardDrawnValue;
        }

    public int dealer(Player dealer) {
        while (dealer.continueDraw()) {
            int drawnCard = drawCard();
            dealer.increaseHand(drawnCard);
            System.out.print("Drawn Card: " + drawnCard + "\n");
            System.out.print("Dealers Hand: " + dealer.getHand() + "\n");
            if (dealer.getHand() == 21) {
                System.out.print("BLACKJACK!!!!");
            }
            if (dealer.getHand() > 21) {
                System.out.print("Dealer Bust!! \n");
            }
        }
        return dealer.getHand();
    }

    public int player() {
        Player player = new Player();
        boolean draw = true;
        int drawnCard = drawCard();
        player.increaseHand(drawnCard);
        System.out.print("Player Drawn Card: " + drawnCard + "\n");
        
        while (draw) {
            Scanner reader = new Scanner(System.in);
            System.out.print("Would you like to hit or stand?\nSelect 0 for hit or 1 for stand  ");
            int n = reader.nextInt();
            if (n < 2 && n >= 0) {
                boolean[] value = { true, false };
                draw = value[n];
                if (n == 1) {
                    reader.close();
                    break;
                }
                int newDrawnCard = drawCard();
                System.out.print("Player Drawn Card: " + newDrawnCard + "\n");

                player.increaseHand(newDrawnCard);
                int handValue = player.getHand();
                System.out.print("Your current hand value is \n" + handValue + "\n");
            } else {
                System.out.print("Select a valid index\n");
                continue;
            }
            if (player.getHand() > 21) {
                System.out.println("Bust!\n");
                break;
            }
            if (player.getHand() == 21) {
                System.out.println("BLACKJACK!\n");
                break;
            }
        }
        return player.getHand();

    }

    public void startGame(){
        Player dealer = new Player();
        int drawCard = dealerDrawCard(dealer);
        dealer.increaseHand(drawCard);
        System.out.print("Dealer draws a " + drawCard + "\n");
        System.out.print("Dealers hand is " + dealer.getHand() + "\n");
        int playerHand = player();
        while(true){
            if(playerHand > 21){
                System.out.print("Player loses....");
                break;
            }
            int dealerHand = dealer(dealer);
            if(playerHand > dealerHand & playerHand <= 21){
                System.out.print("PLAYER WINS!!!");
                break;
            }
            if(dealerHand > 21 & playerHand <= 21){
                System.out.print("PLAYER WINS!!!");
                break;
            }
            if(playerHand < dealerHand & dealerHand <= 21){
                System.out.print("Dealer wins:(");
                break;
            }
            if(playerHand == dealerHand){
                System.out.print("Draw");
                break;
            }
        }
    }

    public void dealerAce(){

    }
}

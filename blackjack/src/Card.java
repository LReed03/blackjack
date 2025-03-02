import java.util.Scanner;

public class Card {
    private Rank rank;
    private int cardValue;
    private Suit suit;

    public Card(Suit suit, Rank rank){
        this.rank = rank;
        this.suit = suit;
    }
    public void setRank(Rank rank){
        this.rank = rank;
    }

    public void setCardValue(Rank rank){
        switch(rank){
            case ACE:
                Scanner readerAce = new Scanner(System.in);
                while(true){
                    System.out.print("You pulled an Ace Select 0 for 11 and 1 for 1   \n");
                    int n = readerAce.nextInt();
                    if(n < 2 && n >= 0){
                        int[] value = {11,1};
                        this.cardValue = value[n];
                        
                        break;
                    }
                    System.out.print("Select a valid index\n");
                    
                }
                break;
            case TWO:
                this.cardValue = 2;
                break;
            case THREE:
                this.cardValue = 3;
                break;
            case FOUR:
                this.cardValue = 4;
                break;
            case FIVE:
                this.cardValue = 5;
                break;
            case SIX:
                this.cardValue = 6;
                break;
            case SEVEN:
                this.cardValue = 7;
                break;
            case EIGHT:
                this.cardValue = 8;
                break;
            case NINE:
                this.cardValue = 9;
                break;
            default:
                this.cardValue = 10;
                break;

            

        }
    }

    public void setCardValue(int i){
        this.cardValue = i;
    }

    public void setSuit(Suit suit){
        this.suit = suit;
    }

    public Rank getRank(){
        return this.rank;
    }

    public int getCardValue(){
        return this.cardValue;
    }

    public Suit getSuit(){
        return this.suit;
    }
}

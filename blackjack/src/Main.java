

public class Main {
    public static void main(String[] args) throws Exception {
        Card card = new Card(Suit.HEARTS, Rank.ACE);
        card.setCardValue(card.getRank());
        System.out.print(card.getCardValue());



    }
}

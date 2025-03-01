public class Dealer {
    private int currentHand;

    public Dealer(){
        this.currentHand = 0;
    }

    public int increaseHand(int cardValue){
        return this.currentHand += cardValue;
    }

    public boolean continueDraw(){
        if(this.currentHand > 16){
            return false;
        }
        else{
            return true;
        }
    }

    public int getHand(){
        return this.currentHand;
    }
}

package frubana.stonePaperScissors.v1;

import static frubana.stonePaperScissors.v1.HandType.*;

public class Hand {

    public static Hand paper = new Hand(Paper, Stone);
    public static Hand stone = new Hand(Stone, Scissors);
    public static Hand scissors = new Hand(Scissors, Paper);

    private HandType type;
    private HandType winsTo;

    private Hand(HandType type, HandType winsTo){
        this.type = type;
        this.winsTo = winsTo;
    }

    public boolean play(Hand otherHand) {
        if (otherHand.type.equals(winsTo)) {
            return true;
        }
        return false;
    }

}

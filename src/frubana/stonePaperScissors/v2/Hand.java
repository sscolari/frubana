package frubana.stonePaperScissors.v2;

import java.util.function.Function;

public abstract class Hand {

    Function<Hand, Boolean> winsTo;

    //true -> win
    //false -> loose
    public boolean play(Hand otherHand) {
        if (winsTo.apply(otherHand)) {
            return true;
        }
        return false;
    }

    public boolean isStone() {
        return false;
    }

    public boolean isScissors() {
        return false;
    }

    public boolean isPaper() {
        return false;
    }

}

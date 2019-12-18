package frubana.stonePaperScissors.v2;

public class Scissors extends Hand {

    public Scissors() {
        winsTo = Hand::isPaper;
    }

    @Override
    public boolean isScissors() {
        return true;
    }
}

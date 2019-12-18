package frubana.stonePaperScissors.v2;

public class Paper extends Hand {

    public Paper () {
        winsTo = Hand::isStone;
    }

    @Override
    public boolean isPaper() {
        return true;
    }

}

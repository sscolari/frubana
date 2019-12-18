package frubana.stonePaperScissors.v2;

public class Stone extends Hand {

    public Stone() {
        winsTo = Hand::isScissors;
    }

    @Override
    public boolean isStone() {
        return true;
    }

}

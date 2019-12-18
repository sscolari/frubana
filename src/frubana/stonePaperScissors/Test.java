package frubana.stonePaperScissors;

import frubana.stonePaperScissors.v1.Hand;
import frubana.stonePaperScissors.v2.Paper;
import frubana.stonePaperScissors.v2.Scissors;
import frubana.stonePaperScissors.v2.Stone;

public class Test {

    public static void main(String[] args) {
        System.out.println("V1");
        System.out.println("Paper - Scissors -> " + Hand.paper.play(Hand.scissors));
        System.out.println("Paper - Stone -> " + Hand.paper.play(Hand.stone));

        System.out.println("V2");
        System.out.println("Paper - Scissors -> " + new Paper().play(new Scissors()));
        System.out.println("Paper - Stone -> " + new Paper().play(new Stone()));
    }

}

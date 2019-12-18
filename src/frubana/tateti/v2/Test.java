package frubana.tateti.v2;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

    public static void main(String[] args) {

        List<Pair<Integer, Integer>> spots = new ArrayList<>();
        spots.add(new Pair<>(0, 0));
        spots.add(new Pair<>(0, 1));
        spots.add(new Pair<>(0, 2));
        spots.add(new Pair<>(1, 0));
        spots.add(new Pair<>(1, 1));
        spots.add(new Pair<>(1, 2));
        spots.add(new Pair<>(2, 0));
        spots.add(new Pair<>(2, 1));
        spots.add(new Pair<>(2, 2));

        Board board = new Board();

        SpotValue turn = SpotValue.X;
        SpotValue winner = null;
        while (winner == null && spots.size() > 0) {
            Pair<Integer, Integer> spot = spots.remove(new Random().nextInt(spots.size()));
            System.out.println("Playing (" + spot.getKey() + "," + spot.getValue() + ") -> " + turn);
            boolean result = board.play(spot.getKey(), spot.getValue(), turn);
            if (result) {
                winner = turn;
                System.out.println("The winner is " + turn);
            } else {
                if (turn == SpotValue.X) {
                    turn = SpotValue.O;
                } else {
                    turn = SpotValue.X;
                }
            }

        }

        if (winner == null) {
            System.out.println("Deuce");
        }

        System.out.println(board);

    }

}

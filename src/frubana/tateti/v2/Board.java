package frubana.tateti.v2;

import java.util.Arrays;
import java.util.List;

import static frubana.tateti.v2.SpotValue.Empty;

public class Board {

    private List<List<Integer>> wins = Arrays.asList(
            Arrays.asList(0,1,2),
            Arrays.asList(3,4,5),
            Arrays.asList(6,7,8),
            Arrays.asList(0,3,6),
            Arrays.asList(1,4,7),
            Arrays.asList(2,5,8),
            Arrays.asList(0,4,8),
            Arrays.asList(2,4,6));


    private SpotValue[][] game = new SpotValue[][] {
            {Empty, Empty, Empty},
            {Empty, Empty, Empty},
            {Empty, Empty, Empty},
    };

    public boolean play(int x, int y, SpotValue turn) {
        game[x][y] = turn;
        return win(turn);
    }

    private boolean win(SpotValue turn) {
        return wins.stream().anyMatch(winGame -> {
            boolean result = winGame.stream().allMatch(i -> {
                return turn == game[i/3][i-(3*(i/3))];
            });
            if (result) System.out.println(winGame);
            return result;
        });
    }

    @Override
    public String toString() {
        return print(game[0][0]) + " | " + print(game[0][1]) + " | " + print(game[0][2])  + "\n"
               + "----------\n"
               + print(game[1][0]) + " | " + print(game[1][1]) + " | " + print(game[1][2])  + "\n"
               + "----------\n"
               + print(game[2][0]) + " | " + print(game[2][1]) + " | " + print(game[2][2]);
    }

    private String print(SpotValue value) {
        if (value.equals(Empty)) {
            return " ";
        } else {
            return value.toString();
        }
    }
}

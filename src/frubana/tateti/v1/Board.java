package frubana.tateti.v1;

import static frubana.tateti.v1.Spot.*;

public class Board {

    private Spot[][] game = new Spot[][] {
            {SPOT_1, SPOT_2, SPOT_3},
            {SPOT_4, SPOT_5, SPOT_6},
            {SPOT_7, SPOT_8, SPOT_9},
    };

    public boolean play(int x, int y, SpotValue turn) {
        Spot currentSpot = game[x][y];
        currentSpot.setValue(turn);
        return currentSpot.win(this, turn);
    }

    @Override
    public String toString() {
        return print(SPOT_1) + " | " + print(SPOT_2) + " | " + print(SPOT_3)  + "\n"
               + "----------\n"
               + print(SPOT_4) + " | " + print(SPOT_5) + " | " + print(SPOT_6)  + "\n"
               + "----------\n"
               + print(SPOT_7) + " | " + print(SPOT_8) + " | " + print(SPOT_9);
    }

    private String print(Spot spot1) {
        if (spot1.getValue().equals(SpotValue.Empty)) {
            return " ";
        } else {
            return spot1.getValue().toString();
        }
    }
}

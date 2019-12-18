package frubana.tateti.v1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static frubana.tateti.v1.Direction.*;

public class Spot {

    public static final Spot SPOT_1 = new Spot(0, Arrays.asList(Arrays.asList(Right), Arrays.asList(Down), Arrays.asList(DiagDownRight)));
    public static final Spot SPOT_2 = new Spot(1, Arrays.asList(Arrays.asList(Left, Right), Arrays.asList(Down)));
    public static final Spot SPOT_3 = new Spot(2, Arrays.asList(Arrays.asList(Left), Arrays.asList(Down), Arrays.asList(DiagDownLeft)));
    public static final Spot SPOT_4 = new Spot(3, Arrays.asList(Arrays.asList(Up, Down), Arrays.asList(Right)));
    public static final Spot SPOT_5 = new Spot(4, Arrays.asList(Arrays.asList(Left, Right), Arrays.asList(Up, Down), Arrays.asList(DiagTopLeft, DiagDownRight), Arrays.asList(DiagTopRight, DiagDownLeft)));
    public static final Spot SPOT_6 = new Spot(5, Arrays.asList(Arrays.asList(Left), Arrays.asList(Up, Down)));
    public static final Spot SPOT_7 = new Spot(6, Arrays.asList(Arrays.asList(Up), Arrays.asList(Right), Arrays.asList(DiagTopRight)));
    public static final Spot SPOT_8 = new Spot(7, Arrays.asList(Arrays.asList(Up), Arrays.asList(Left, Right)));
    public static final Spot SPOT_9 = new Spot(8, Arrays.asList(Arrays.asList(Left), Arrays.asList(Up), Arrays.asList(DiagTopLeft)));

    static {
        SPOT_1.neighborhoods = new HashMap<>();
        SPOT_1.neighborhoods.put(Right, SPOT_2);
        SPOT_1.neighborhoods.put(Down, SPOT_4);
        SPOT_1.neighborhoods.put(DiagDownRight, SPOT_5);

        SPOT_2.neighborhoods = new HashMap<>();
        SPOT_2.neighborhoods.put(Left, SPOT_1);
        SPOT_2.neighborhoods.put(Right, SPOT_3);
        SPOT_2.neighborhoods.put(Down, SPOT_5);

        SPOT_3.neighborhoods = new HashMap<>();
        SPOT_3.neighborhoods.put(Left, SPOT_2);
        SPOT_3.neighborhoods.put(Down, SPOT_6);
        SPOT_3.neighborhoods.put(DiagDownLeft, SPOT_5);

        SPOT_4.neighborhoods = new HashMap<>();
        SPOT_4.neighborhoods.put(Up, SPOT_1);
        SPOT_4.neighborhoods.put(Right, SPOT_5);
        SPOT_4.neighborhoods.put(Down, SPOT_7);

        SPOT_5.neighborhoods = new HashMap<>();
        SPOT_5.neighborhoods.put(Up, SPOT_2);
        SPOT_5.neighborhoods.put(Down, SPOT_8);
        SPOT_5.neighborhoods.put(Left, SPOT_4);
        SPOT_5.neighborhoods.put(Right, SPOT_6);
        SPOT_5.neighborhoods.put(DiagTopLeft, SPOT_1);
        SPOT_5.neighborhoods.put(DiagTopRight, SPOT_3);
        SPOT_5.neighborhoods.put(DiagDownLeft, SPOT_7);
        SPOT_5.neighborhoods.put(DiagDownRight, SPOT_9);

        SPOT_6.neighborhoods = new HashMap<>();
        SPOT_6.neighborhoods.put(Up, SPOT_3);
        SPOT_6.neighborhoods.put(Left, SPOT_5);
        SPOT_6.neighborhoods.put(Down, SPOT_9);

        SPOT_7.neighborhoods = new HashMap<>();
        SPOT_7.neighborhoods.put(Up, SPOT_4);
        SPOT_7.neighborhoods.put(Right, SPOT_8);
        SPOT_7.neighborhoods.put(DiagTopRight, SPOT_5);

        SPOT_8.neighborhoods = new HashMap<>();
        SPOT_8.neighborhoods.put(Up, SPOT_5);
        SPOT_8.neighborhoods.put(Left, SPOT_7);
        SPOT_8.neighborhoods.put(Right, SPOT_9);

        SPOT_9.neighborhoods = new HashMap<>();
        SPOT_9.neighborhoods.put(Up, SPOT_6);
        SPOT_9.neighborhoods.put(Left, SPOT_8);
        SPOT_9.neighborhoods.put(DiagTopLeft, SPOT_5);

    }


    private final int number;
    private final List<List<Direction>> directions;
    private Map<Direction, Spot> neighborhoods = new HashMap<>();
    private SpotValue value = SpotValue.Empty;

    private Spot(int number, List<List<Direction>> directions) {
        this.number = number;
        this.directions = directions;
    }

    public void setValue(SpotValue value) {
        this.value = value;
    }

    public SpotValue getValue() {
        return value;
    }

    public boolean win(Board board, SpotValue value) {
        if (this.value != value) {
            return false;
        }
        return directions.stream().anyMatch(directions1 ->
            directions1.stream().allMatch(direction -> {
                Spot next = neighborhoods.get(direction);
                return next.check(value, direction);
            })
        );
    }

    private boolean check(SpotValue otherValue, Direction direction) {
        Spot next = neighborhoods.get(direction);
        if (value.equals(otherValue) && next != null) {
            return next.check(otherValue, direction);
        }
        return value.equals(otherValue);
    }
}

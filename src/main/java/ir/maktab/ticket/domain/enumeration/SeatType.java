package ir.maktab.ticket.domain.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum SeatType {
    ECONOMY(0), BUSINESS(1);
    private int index;
    private static Map map = new HashMap<>();
    static {
        for (SeatType type :
                SeatType.values()) {
            map.put(type.index, type);
        }
    }
    SeatType(int index) {
        this.index = index;
    }
    public static SeatType typeOf(int index) {
        return (SeatType) map.get(index);
    }
}

import java.time.LocalTime;
import java.util.*;

class Solution {
    public static int solution(String[][] book_time) {
        Map<LocalTime, Integer> map = new HashMap<>();
        for (LocalTime time = LocalTime.of(0,0); time.isBefore(LocalTime.of(23, 59)); time = time.plusMinutes(1)) {
            map.put(time, 0);
        }
        map.put(LocalTime.of(23, 59), 0);

        for (String[] time : book_time) {
            LocalTime start = LocalTime.parse(time[0]);
            LocalTime end = LocalTime.parse(time[1]);
            if (end.isBefore(LocalTime.of(23, 51))) {
                end = end.plusMinutes(9);
            } else {
                end = LocalTime.of(23, 59);
            }

            for (LocalTime t = start; t.isBefore(end); t = t.plusMinutes(1)) {
                map.put(t, map.get(t) + 1);
            }
            map.put(end, map.get(end) + 1);
        }

        return map.values().stream().max(Integer::compareTo).orElse(0);
    }
}

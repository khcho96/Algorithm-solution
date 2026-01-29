import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String record : records) {
            LocalTime time = LocalTime.parse(record.split(" ")[0]);
            String carNum = record.split(" ")[1];

            if (!map.containsKey(carNum)) map.put(carNum, new ArrayList<>());
            map.get(carNum).add(time.getHour() * 60 + time.getMinute());
        }

        for (String string : map.keySet()) {
            if (map.get(string).size() % 2 == 1) {
                map.get(string).add(23 * 60 + 59);
            }
        }

        Map<String, Integer> minutes = new HashMap<>();
        for (String string : map.keySet()) {
            int minute = 0;
            for (int i = 0; i < map.get(string).size(); i += 2) {
                minute += map.get(string).get(i + 1) - map.get(string).get(i);
            }
            minutes.put(string, minute);
        }

        int[] answer = new int[minutes.size()];
        int index = 0;
        for (String string : minutes.keySet().stream().sorted(String::compareTo).collect(Collectors.toList())) {
            int minute = minutes.get(string);
            if (minute <= fees[0]) {
                answer[index++] = fees[1];
            } else {
                answer[index] = fees[1] + (minute - fees[0]) / fees[2] * fees[3];
                if ((minute - fees[0]) % fees[2] > 0) answer[index] += fees[3];
                index++;
            }
        }
        return answer;
    }
}
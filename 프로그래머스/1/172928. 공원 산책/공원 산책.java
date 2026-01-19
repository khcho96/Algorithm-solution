import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        Map<String, List<Integer>> map = Map.of(
                "E", List.of(0, 1),
                "W", List.of(0, -1),
                "S", List.of(1, 0),
                "N", List.of(-1, 0)
        );

        List<Integer> start = List.of();
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') start = List.of(i, j);
            }
        }

        List<Integer> cur = new ArrayList<>();
        for (String route : routes) {
            List<Integer> direction = map.get(route.split(" ")[0]);
            int distance = Integer.parseInt(route.split(" ")[1]);

            cur = new ArrayList<>(start);
            for (int i = 0; i < distance; i++) {
                cur.set(0, cur.get(0) + direction.get(0));
                cur.set(1, cur.get(1) + direction.get(1));
                if (!isMovePossible(cur, park)) {
                    cur = new ArrayList<>();
                    break;
                }
            }
            if (!cur.isEmpty()) start = cur;
        }
        
        return start.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public boolean isMovePossible(List<Integer> cur, String[] park) {
        return (0 <= cur.get(0) && cur.get(0) < park.length)
                && (0 <= cur.get(1) && cur.get(1) < park[0].length())
                && (park[cur.get(0)].charAt(cur.get(1)) != 'X');
    }
}
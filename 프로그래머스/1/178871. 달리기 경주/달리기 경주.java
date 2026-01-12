import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> indexs = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            indexs.put(players[i], i);
        }

        for (String calling : callings) {
            int oldIndex = indexs.get(calling);
            int newIndex = oldIndex - 1;

            String loser = players[newIndex];

            players[oldIndex] = loser;
            players[newIndex] = calling;

            indexs.put(loser, oldIndex);
            indexs.put(calling, newIndex);
        }

        return players;
    }
}
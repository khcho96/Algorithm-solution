import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        List<String> playersList = new ArrayList<>(List.of(players));
        Map<String, Integer> indexs = new HashMap<>();
        for (String player : players) {
            indexs.put(player, playersList.indexOf(player));
        }

        for (String calling : callings) {
            int oldIndex = indexs.get(calling);
            int newIndex = oldIndex - 1;

            String loser = playersList.get(newIndex);

            playersList.set(oldIndex, loser);
            playersList.set(newIndex, calling);

            indexs.put(loser, oldIndex);
            indexs.put(calling, newIndex);
        }

        String[] answer = new String[playersList.size()];
        for (int i = 0; i < playersList.size(); i++) {
            answer[i] = playersList.get(i);
        }
        return answer;
    }
}
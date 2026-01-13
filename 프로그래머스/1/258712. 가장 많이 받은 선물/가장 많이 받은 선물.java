import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        List<List<String>> pairs = new ArrayList<>();
        Map<List<String>, Integer> giveAndTakes = new HashMap<>();
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                pairs.add(List.of(friends[i], friends[j]));

                giveAndTakes.put(List.of(friends[i], friends[j]), 0);
                giveAndTakes.put(List.of(friends[j], friends[i]), 0);
            }
        }

        Map<String, Integer> giftIndex = new HashMap<>();
        for (String friend : friends) {
            giftIndex.put(friend, 0);
        }

        for (String gift : gifts) {
            String sender = gift.split(" ")[0];
            String receiver = gift.split(" ")[1];
            List<String> pair = List.of(sender, receiver);

            giveAndTakes.put(pair, giveAndTakes.get(pair) + 1);

            giftIndex.put(sender, giftIndex.get(sender) + 1);
            giftIndex.put(receiver, giftIndex.get(receiver) - 1);
        }

        Map<String, Integer> getGiftCount = new HashMap<>();
        for (List<String> pair : pairs) {
            String friend1 = pair.get(0);
            String friend2 = pair.get(1);
            int friend1ToFriend2 = giveAndTakes.get(List.of(friend1, friend2));
            int friend2ToFriend1 = giveAndTakes.get(List.of(friend2, friend1));

            if (friend1ToFriend2 > friend2ToFriend1) {
                getGiftCount.put(friend1, getGiftCount.getOrDefault(friend1, 0) + 1);
            } else if (friend1ToFriend2 < friend2ToFriend1) {
                getGiftCount.put(friend2, getGiftCount.getOrDefault(friend2, 0) + 1);
            } else {
                Integer friend1Index = giftIndex.get(friend1);
                Integer friend2Index = giftIndex.get(friend2);
                if (friend1Index > friend2Index) {
                    getGiftCount.put(friend1, getGiftCount.getOrDefault(friend1, 0) + 1);
                } else if (friend1Index < friend2Index) {
                    getGiftCount.put(friend2, getGiftCount.getOrDefault(friend2, 0) + 1);
                }
            }
        }

        int answer = getGiftCount.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        
        return answer;
    }
}
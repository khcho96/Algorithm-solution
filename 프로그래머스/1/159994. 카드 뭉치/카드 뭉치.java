import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> deque1 = new ArrayDeque<>(List.of(cards1));
        Deque<String> deque2 = new ArrayDeque<>(List.of(cards2));
        Deque<String> goals = new ArrayDeque<>(List.of(goal));

        while (true) {
            String target = goals.pollFirst();
            
            if (target == null) break;

            if (!deque1.isEmpty() && deque1.peekFirst().equals(target)) {
                deque1.removeFirst();
            } else if (!deque2.isEmpty() && deque2.peekFirst().equals(target)) {
                deque2.removeFirst();
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}
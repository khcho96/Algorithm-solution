import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String X, String Y) {
        Deque<String> XDeque = Arrays.stream(X.split("")).sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<String> YDeque = Arrays.stream(Y.split("")).sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(ArrayDeque::new));

        StringBuilder string = new StringBuilder();
        while (!XDeque.isEmpty() && !YDeque.isEmpty()) {
            String x = XDeque.peekFirst();
            String y = YDeque.peekFirst();

            int xInt = Integer.parseInt(x);
            int yInt = Integer.parseInt(y);

            if (xInt == yInt) {
                string.append(x);
                XDeque.removeFirst();
                YDeque.removeFirst();
            } else if (xInt > yInt) {
                XDeque.removeFirst();
            } else {
                YDeque.removeFirst();
            }
        }
        
        String answer = string.toString();
        if (answer.isBlank()) return "-1";
        if (answer.matches("0+")) return "0";
        return answer;
    }
}
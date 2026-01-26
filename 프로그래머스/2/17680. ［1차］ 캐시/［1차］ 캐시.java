import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Deque<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        
        if (cacheSize == 0) return cities.length * 5;

        int answer = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if (set.contains(city)) {
                answer++;
                queue.remove(city);
                queue.addLast(city);
            } else {
                answer += 5;
                if (set.size() == cacheSize) {
                    String old = queue.pollFirst();
                    set.remove(old);
                }
                queue.addLast(city);
                set.add(city);
            }
        }
        return answer;
    }
}
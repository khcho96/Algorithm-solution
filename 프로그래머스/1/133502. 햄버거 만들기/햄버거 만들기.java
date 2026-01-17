import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int in : ingredient) {
            list.add(in);
            if (list.size() >= 4 && in == 1) {
                if (list.get(list.size() - 4) == 1 && list.get(list.size() - 3) == 2 && list.get(list.size() - 2) == 3) {
                    answer++;
                    for (int i = 0; i < 4; i++) list.remove(list.size() - 1);
                }
            }
        }
        return answer;
    }
}
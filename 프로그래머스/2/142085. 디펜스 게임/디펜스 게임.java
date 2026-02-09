import java.util.*;

class Solution {
    public static int solution(int n, int k, int[] enemy) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        int index = 0;
        while (true) {
            if (n - enemy[index] >= 0) {
                map.put(enemy[index], map.getOrDefault(enemy[index], 0) + 1);
                n -= enemy[index++];
            } else if (k > 0) {
                k--;
                if (!map.isEmpty()) {
                    for (Integer key : map.keySet()) {
                        if (key >= enemy[index]) {
                            n += key;
                            map.put(key, map.get(key) - 1);
                            if (map.get(key) == 0)
                                map.remove(key);
                        } else {
                            index++;
                        }
                        break;
                    }
                } else {
                    index++;
                }
            } else break;

            if (index == enemy.length) {
                break;
            }
        }

        return index;
    }
}

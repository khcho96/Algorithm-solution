import java.util.*;

class Solution {

    public int[][] solution(int n) {
        List<List<Integer>> list = new ArrayList<>();
        func(list, n, 1, 3);

        int[][] answer = new int[list.size()][2];
        int index = 0;
        for (List<Integer> integers : list) {
            answer[index++] = new int[]{integers.get(0), integers.get(1)};
        }
        return answer;
    }

    private void func(List<List<Integer>> list, int n, int from, int to) {
        if (n == 1) {
            list.add(List.of(from, to));
            return;
        }

        int newTo = 0;
        for (int i = 1; i <= 3; i++) if (i != from && i != to) newTo = i;

        func(list, n - 1, from, newTo);
        list.add(List.of(from, to));
        func(list, n - 1, newTo, to);
    }
}

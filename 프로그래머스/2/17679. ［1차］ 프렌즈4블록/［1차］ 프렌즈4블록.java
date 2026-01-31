import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        String[][] grid = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] split = board[i].split("");
            for (int j = 0; j < n; j++) {
                grid[i][j] = split[j];
            }
        }

        int answer = 0;

        while (true) {
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (!grid[i][j].isEmpty() && grid[i][j].equals(grid[i + 1][j]) && grid[i + 1][j].equals(
                            grid[i][j + 1]) && grid[i][j + 1].equals(grid[i + 1][j + 1])) {
                        set.add(List.of(i, j));
                        set.add(List.of(i + 1, j));
                        set.add(List.of(i, j + 1));
                        set.add(List.of(i + 1, j + 1));
                    }
                }
            }

            if (set.isEmpty()) break;

            answer += set.size();

            for (List<Integer> list : set) {
                grid[list.get(0)][list.get(1)] = "";
            }

            for (int j = 0; j < n; j++) {
                while (true) {
                    boolean isChange = false;
                    for (int i = 0; i < m - 1; i++) {
                        if (!grid[i][j].isEmpty() && grid[i + 1][j].isEmpty()) {
                            isChange = true;
                            String temp = grid[i][j];
                            grid[i][j] = grid[i + 1][j];
                            grid[i + 1][j] = temp;
                        }
                    }
                    if (!isChange) break;
                }
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || picture[i][j] == 0) continue;

                maxSizeOfOneArea = Math.max(dfs(visited, picture, i, j, picture[i][j]), maxSizeOfOneArea);
                numberOfArea++;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int dfs(boolean[][] visited, int[][] picture, int i, int j, int value) {
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length) return 0;
        if (visited[i][j] || picture[i][j] != value) return 0;

        visited[i][j] = true;
        int size = 0;
        size += dfs(visited, picture, i - 1, j, value);
        size += dfs(visited, picture, i + 1, j, value);
        size += dfs(visited, picture, i, j - 1, value);
        size += dfs(visited, picture, i, j + 1, value);

        return size + 1;
    }
}

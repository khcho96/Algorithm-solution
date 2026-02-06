import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r == n-1 && c == m-1) {
                // 목표 도착: 더 짧은 경로는 나올 수 없으므로 바로 반환
                return dist[r][c];
            }
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (maps[nr][nc] == 0 || dist[nr][nc] != -1) continue;
                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }

        // 도달하지 못했으면 -1
        return -1;
    }
}

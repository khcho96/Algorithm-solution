import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1, 0}); // x, y, count, crushed
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            int isCrushed = cur[3];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (nx == N - 1 && ny == M - 1) {
                    System.out.println(count + 1);
                    return;
                }

                if (map[nx][ny] == 0 && !visited[nx][ny][isCrushed]) {
                    visited[nx][ny][isCrushed] = true;
                    queue.offer(new int[]{nx, ny, count + 1, isCrushed});
                }

                if (map[nx][ny] == 1 && isCrushed == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.offer(new int[]{nx, ny, count + 1, 1});
                }
            }
        }

        System.out.println(-1);
    }
}

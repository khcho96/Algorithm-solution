import java.io.*;
import java.util.*;

class Main {

    static int M;
    static int N;
    static int[][] tomatoes;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        tomatoes = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            tomatoes[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Queue<List<Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] != 1) continue;
                queue.offer(List.of(i, j, 0));
                visited[i][j] = true;
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            int i = cur.get(0);
            int j = cur.get(1);
            int seconds = cur.get(2);

            for (int k = 0; k < 4; k++) {
                int newI = i + dx[k];
                int newJ = j + dy[k];
                if (newI >= 0 && newI < N && newJ >= 0 && newJ < M
                        && !visited[newI][newJ] && tomatoes[newI][newJ] == 0) {
                    queue.offer(List.of(newI, newJ, seconds + 1));
                    answer = seconds + 1;
                    visited[newI][newJ] = true;
                    tomatoes[newI][newJ] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer);
    }
}

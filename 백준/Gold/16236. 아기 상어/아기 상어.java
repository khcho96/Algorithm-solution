import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Main {

    static int N;
    static int[][] mat;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static int sharkX;
    static int sharkY;
    static int size = 2;
    static int sizeCount = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        mat = new int[N][N];

        for (int i = 0; i < N; i++) {
            mat[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    mat[i][j] = 0;
                }
            }
        }

        while (true) {
            int[] target = bfs();

            if (target[0] == -1) {
                break;
            }

            int tx = target[0];
            int ty = target[1];
            int dist = target[2];

            answer += dist;
            sharkX = tx;
            sharkY = ty;
            mat[tx][ty] = 0;

            sizeCount++;
            if (sizeCount == size) {
                size++;
                sizeCount = 0;
            }
        }

        System.out.println(answer);
    }

    private static int[] bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        visit = new boolean[N][N];

        queue.offer(new int[]{sharkX, sharkY, 0});
        visit[sharkX][sharkY] = true;

        int bestX = -1;
        int bestY = -1;
        int bestDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (dist > bestDist) {
                continue;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int newDist = dist + 1;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] || mat[nx][ny] > size) {
                    continue;
                }

                if (mat[nx][ny] != 0 && mat[nx][ny] < size) {
                    if (newDist < bestDist || (newDist == bestDist && nx < bestX) || (newDist == bestDist && nx == bestX && ny < bestY)) {
                        bestX = nx;
                        bestY = ny;
                        bestDist = newDist;
                    }
                }

                queue.offer(new int[]{nx, ny, newDist});
                visit[nx][ny] = true;
            }
        }

        return new int[]{bestX, bestY, bestDist};
    }
}
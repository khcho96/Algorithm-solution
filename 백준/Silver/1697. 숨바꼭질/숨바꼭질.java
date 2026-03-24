import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int K;
    static int[] list = new int[100_001];
    static boolean[] visited = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        visited[N] = true;

        int answer = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int x1 = cur - 1;
            if (x1 >= 0 && x1 < 100_001 && !visited[x1]) {
                queue.offer(x1);
                visited[x1] = true;
                list[x1] = list[cur] + 1;

                if (x1 == K) {
                    answer = list[x1];
                    break;
                }
            }

            int x2 = cur + 1;
            if (x2 >= 0 && x2 < 100_001 && !visited[x2]) {
                queue.offer(x2);
                visited[x2] = true;

                list[x2] = list[cur] + 1;

                if (x2 == K) {
                    answer = list[x2];
                    break;
                }
            }

            int x3 = cur * 2;
            if (x3 >= 0 && x3 < 100_001 && !visited[x3]) {
                queue.offer(x3);
                visited[x3] = true;

                list[x3] = list[cur] + 1;

                if (x3 == K) {
                    answer = list[x3];
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}

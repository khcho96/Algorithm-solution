import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Main {

    static int N;
    static int[][] mat;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        mat = new int[N][N];
        for (int i = 0; i < N; i++) {
            mat[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        visited = new boolean[N][N];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                visited[i][j] = false;
//            }
//        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = dfs(i, j, 0);
                if (count > 0) list.add(count);
            }
        }
        list.sort(Comparator.comparingInt(Integer::intValue));

        System.out.println(list.size());
        for (Integer count : list) {
            System.out.println(count);
        }
    }

    private static int dfs(int i, int j, int count) {
        if (i < 0 || i >= N || j < 0 || j >= N || visited[i][j] || mat[i][j] == 0) return count;

        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            count = dfs(i + dx[k], j + dy[k], count);
        }

        return count + 1;
    }
}

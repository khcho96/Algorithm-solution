import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[][] mat;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickenStores = new ArrayList<>();
    static List<int[]> candidates = new ArrayList<>();
    static boolean[] visit;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mat = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            mat[i] = new int[N];
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                mat[i][j] = value;
                if (value == 1) {
                    houses.add(new int[]{i, j});
                }
                if (value == 2) {
                    chickenStores.add(new int[]{i, j});
                }
            }
        }

        visit = new boolean[chickenStores.size()];

        for (int i = 0; i < chickenStores.size(); i++) {
            visit[i] = true;
            candidates.add(chickenStores.get(i));
            func(i);
            visit[i] = false;
            candidates.remove(candidates.size() - 1);
        }

        System.out.println(answer);
    }

    private static void func(int cur) {
        if (candidates.size() == M) {
            int dist = calculateDistance();
            if (answer > dist) answer = dist;
            return;
        }

        for (int i = cur; i < chickenStores.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                candidates.add(chickenStores.get(i));
                func(i);
                visit[i] = false;
                candidates.remove(candidates.size() - 1);
            }
        }
    }

    private static int calculateDistance() {
        int res = 0;
        for (int[] house : houses) {
            int min = Integer.MAX_VALUE;
            for (int[] candidate : candidates) {
                int dist = Math.abs(house[0] - candidate[0]) + Math.abs(house[1] - candidate[1]);
                if (min > dist) min = dist;
            }
            res += min;
        }
        return res;
    }
}

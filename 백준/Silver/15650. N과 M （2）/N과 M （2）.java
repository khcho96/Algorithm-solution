import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static boolean[] visit;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            list.add(i);
            func(i);
            list.remove(list.size() - 1);
            visit[i] = false;
        }
    }

    private static void func(int cur) {
        if (list.size() == M) {
            System.out.println(String.join(" ", list.stream().map(String::valueOf).toArray(String[]::new)));
            return;
        }

        for (int i = cur; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                list.add(i);
                func(i);
                list.remove(list.size() - 1);
                visit[i] = false;
            }
        }
    }
}
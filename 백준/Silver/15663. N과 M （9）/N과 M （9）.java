import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[] array;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static Set<String> answer = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N];
        visit = new boolean[N];

        int index = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreElements()) {
            array[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        for (int i = 0; i < N; i++) {
            sb.append(array[i]).append(" ");
            visit[i] = true;
            func(1);
            visit[i] = false;
            sb.delete(sb.length() - 1, sb.length());
            sb.delete(sb.lastIndexOf(" ") + 1, sb.length());
        }

        StringBuilder a = new StringBuilder();
        for (String s : answer) {
            a.append(s).append("\n");
        }

        System.out.println(a);
    }

    private static void func(int count) {
        if (count == M) {
            answer.add(String.valueOf(sb));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                sb.append(array[i]).append(" ");
                visit[i] = true;
                func(count + 1);
                visit[i] = false;
                sb.delete(sb.length() - 1, sb.length());
                sb.delete(sb.lastIndexOf(" ") + 1, sb.length());
            }
        }
    }
}

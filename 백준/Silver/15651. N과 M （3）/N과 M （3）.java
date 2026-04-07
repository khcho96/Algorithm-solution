import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            sb.append(i).append(" ");
            func(1);
            sb.delete(sb.length() - 2, sb.length());
        }

        System.out.println(answer);
    }

    private static void func(int count) {
        if (count == M) {
            answer.append(sb).append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            sb.append(i).append(" ");
            func(count + 1);
            sb.delete(sb.length() - 2, sb.length());
        }
    }
}
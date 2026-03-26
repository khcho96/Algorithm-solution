import java.io.*;
import java.util.*;

class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 1; i < N; i++) {
            if (getConstructor(i) == N) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static int getConstructor(int i) {
        int n = i;
        while (i > 0) {
            n += i % 10;
            i /= 10;
        }
        return n;
    }
}

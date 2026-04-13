import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0;; i++) {
            if (N <= 1 + 6 * i * (i + 1) / 2) {
                answer = i + 1;
                break;
            }
        }

        System.out.println(answer);
    }
}

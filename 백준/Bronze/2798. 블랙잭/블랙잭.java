import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;
    static int[] array;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = array[i] + array[j] + array[k];
                    if (sum <= M) {
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

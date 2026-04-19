import java.io.*;

class Main {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N + 1];
            dp[0] = 1;

            for (int j = 1; j <= N; j++) {
                if (j - 3 >= 0) dp[j] += (dp[j - 3] + dp[j - 2] + dp[j - 1]) % 1_000_000_009;
                else if (j - 2 >= 0) dp[j] += (dp[j - 2] + dp[j - 1]) % 1_000_000_009;
                else if (j - 1 >= 0) dp[j] += dp[j - 1] % 1_000_000_009;
            }

            System.out.println(dp[N]);
        }
    }
}

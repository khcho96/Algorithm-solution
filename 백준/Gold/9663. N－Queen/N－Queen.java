import java.io.*;

class Main {

    static int N;
    static int[][] visit;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new int[N][N];

        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                visit[i][j]++;
                if (j + count < N) visit[i][j + count]++;
                if (j - count >= 0) visit[i][j - count]++;
                count++;
            }
            func(1);
            count = 1;
            for (int i = 1; i < N; i++) {
                visit[i][j]--;
                if (j + count < N) visit[i][j + count]--;
                if (j - count >= 0) visit[i][j - count]--;
                count++;
            }
        }

        System.out.println(answer);
    }

    private static void func(int row) {
        if (row == N) {
            answer++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (visit[row][j] == 0) {
                int count = 1;
                for (int i = row + 1; i < N; i++) {
                    visit[i][j]++;
                    if (j + count < N) visit[i][j + count]++;
                    if (j - count >= 0) visit[i][j - count]++;
                    count++;
                }
                func(row + 1);
                count = 1;
                for (int i = row + 1; i < N; i++) {
                    visit[i][j]--;
                    if (j + count < N) visit[i][j + count]--;
                    if (j - count >= 0) visit[i][j - count]--;
                    count++;
                }
            }
        }
    }
}

import java.io.*;
import java.util.Arrays;

class Main {

    static int N;
    static int r;
    static int c;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        r = Integer.parseInt(split[1]);
        c = Integer.parseInt(split[2]);

        func(0, 0, (int) Math.pow(2, N) - 1, (int) Math.pow(2, N) - 1);

        System.out.println(answer);
    }

    private static void func(int i1, int j1, int i2, int j2) {
        if (i1 == i2) return;

        int halfI = (i1 + i2 + 1) / 2;
        int halfJ = (j1 + j2 + 1) / 2;
        if (i1 <= r && r <= halfI - 1 && j1 <= c && c <= halfJ - 1) {
            func(i1, j1, halfI - 1, halfJ - 1);
            return;
        }
        if (i1 <= r && r <= halfI - 1 && halfJ <= c && c <= j2) {
            answer += (halfI - i1) * (halfI - i1);
            func(i1, halfJ, halfI - 1, j2);
            return;
        }
        if (halfI <= r && r <= i2 && j1 <= c && c <= halfJ - 1) {
            answer += (halfI - i1) * (halfI - i1) * 2;
            func(halfI, j1, i2, halfJ - 1);
            return;
        }
        if (halfI <= r && r <= i2 && halfJ <= c && c <= j2) {
            answer += (halfI - i1) * (halfI - i1) * 3;
            func(halfI, halfJ, i2, j2);
        }
    }
}

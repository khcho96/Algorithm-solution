import java.io.*;
import java.util.Arrays;

class Main {

    static int N;
    static int[][] mat;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        mat = new int[N][N];
        for (int i = 0; i < N; i++) {
            mat[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        func(0,0,N-1,N-1);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void func(int i1, int j1, int i2, int j2) {
        if (i1 == i2) {
            if (mat[i1][j1] == 1) {
                blue++;
                return;
            }
            white++;
            return;
        }

        boolean isPaper = true;
        int first = mat[i1][j1];
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (mat[i][j] != first) {
                    isPaper = false;
                    break;
                }
            }
            if (!isPaper) break;
        }

        if (isPaper) {
            if (first == 1) {
                blue++;
                return;
            }
            white++;
            return;
        }

        int half = (i2 - i1 + 1) / 2;
        func(i1, j1, i1 + half - 1, j1 + half - 1);
        func(i1 + half, j1, i2, j1 + half - 1);
        func(i1, j1 + half, i1 + half - 1, j2);
        func(i1 + half, j1 + half, i2, j2);
    }
}

import java.io.*;
import java.util.Arrays;

class Main {

    static int N;
    static String[][] mat;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        mat = new String[N][N];
        for (int i = 0; i < N; i++) {
            mat[i] = br.readLine().split("");
        }

        func(0, 0, N-1, N-1);

        System.out.println(answer.toString());
    }

    private static void func(int i1, int j1, int i2, int j2) {
        if (isCheck(i1,j1,i2,j2)) {
            answer.append(mat[i1][j1]);
            return;
        }

        answer.append("(");

        int halfI = (i2 + i1 + 1) / 2;
        int halfJ = (j2 + j1 + 1) / 2;
        func(i1, j1, halfI - 1, halfJ - 1);
        func(i1, halfJ, halfI - 1, j2);
        func(halfI, j1, i2, halfJ - 1);
        func(halfI, halfJ, i2, j2);

        answer.append(")");
    }

    private static boolean isCheck(int i1, int j1, int i2, int j2) {
        String first = mat[i1][j1];
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (!first.equals(mat[i][j])) return false;
            }
        }

        return true;
    }
}

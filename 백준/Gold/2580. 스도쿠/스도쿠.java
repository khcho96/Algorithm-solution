import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int[][] mat = new int[9][9];
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());

                if (mat[i][j] == 0) list.add(new int[]{i, j});
            }
        }

        for (int i = 1; i <= 9; i++) {
            int[] coordinate = list.get(0);
            if (isPossible(coordinate, i)) {
                mat[coordinate[0]][coordinate[1]] = i;
                if (func(1)) break;
                mat[coordinate[0]][coordinate[1]] = 0;
            }
        }

        for (int i = 0; i < 9; i++) {
            System.out.println(String.join(" ", Arrays.stream(mat[i]).mapToObj(String::valueOf).toArray(String[]::new)));
        }
    }

    private static boolean func(int index) {
        if (index == list.size()) return true;

        for (int i = 1; i <= 9; i++) {
            int[] coordinate = list.get(index);
            if (isPossible(coordinate, i)) {
                mat[coordinate[0]][coordinate[1]] = i;
                if (func(index + 1)) return true;
                mat[coordinate[0]][coordinate[1]] = 0;
            }
        }

        return false;
    }

    private static boolean isPossible(int[] coordinate, int i) {
        // 가로에 i가 있는지 확인
        for (int col = 0; col < 9; col++) {
            if (mat[coordinate[0]][col] == i) return false;
        }

        // 세로에 i가 있는지 확인
        for (int row = 0; row < 9; row++) {
            if (mat[row][coordinate[1]] == i) return false;
        }

        // 3x3 격자에 i가 있는지 확인
        int[] start = getStart(coordinate);
        for (int row = start[0]; row < start[0] + 3; row++) {
            for (int col = start[1]; col < start[1] + 3; col++) {
                if (mat[row][col] == i) return false;
            }
        }

        return true;
    }

    private static int[] getStart(int[] coordinate) {
        int[] start = new int[2];

        if (coordinate[0] < 3) start[0] = 0;
        else if (coordinate[0] < 6) start[0] = 3;
        else start[0] = 6;

        if (coordinate[1] < 3) start[1] = 0;
        else if (coordinate[1] < 6) start[1] = 3;
        else start[1] = 6;

        return start;
    }
}

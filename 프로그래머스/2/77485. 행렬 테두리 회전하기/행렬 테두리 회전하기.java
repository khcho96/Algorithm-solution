import java.util.Arrays;

class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] data = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = value++;
            }
        }

        int index = 0;
        for (int[] query : queries) {
            int x1 = query[0], y1 = query[1], x2 = query[2], y2 = query[3];

            int insert = data[x1 - 1][y1 - 1];
            int min = insert;
            for (int i = y1; i < y2; i++) {
                int temp = data[x1 - 1][i];
                data[x1 - 1][i] = insert;
                insert = temp;
                min = Math.min(min, insert);
            }

            for (int i = x1; i < x2; i++) {
                int temp = data[i][y2 - 1];
                data[i][y2 - 1] = insert;
                insert = temp;
                min = Math.min(min, insert);
            }

            for (int i = y2 - 2; i >= y1 - 1; i--) {
                int temp = data[x2 - 1][i];
                data[x2 - 1][i] = insert;
                insert = temp;
                min = Math.min(min, insert);
            }

            for (int i = x2 - 2; i >= x1 - 1; i--) {
                int temp = data[i][y1 - 1];
                data[i][y1 - 1] = insert;
                insert = temp;
                min = Math.min(min, insert);
            }

            answer[index++] = min;
        }

        return answer;
    }
}

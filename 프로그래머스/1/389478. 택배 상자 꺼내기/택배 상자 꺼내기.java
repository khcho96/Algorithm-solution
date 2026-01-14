class Solution {
    public int solution(int n, int w, int num) {
        int row = (n - 1) / w + 1;

        int[][] list2 = new int[row][w];

        int cnt = 1;
        for (int i = 0; i < row; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    list2[i][j] = cnt++;
                    if (cnt == n + 1) {
                        break;
                    }
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    list2[i][j] = cnt++;
                    if (cnt == n + 1) {
                        break;
                    }
                }
            }
        }

        int floor = (num - 1) / w;
        int index = -1;
        for (int i = 0; i < w; i++) {
            if (list2[floor][i] == num) {
                index = i;
            }
        }

        int answer = 0;
        for (int i = floor; i < row; i++) {
            if (list2[i][index] != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
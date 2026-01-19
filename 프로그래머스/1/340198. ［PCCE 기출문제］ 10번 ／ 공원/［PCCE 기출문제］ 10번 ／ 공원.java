class Solution {
    public int solution(int[] mats, String[][] park) {
        int[][] sizes = new int[park.length][park[0].length];
        int max = -1;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if (park[i][j].equals("-1")) {
                    int size = calculate(park, sizes, i, j);
                    if (size > max) {
                        max = size;
                    }
                }
            }
        }

        int answer = -1;
        for (int mat : mats) {
            if (answer < mat && mat <= max) answer = mat;
        }

        return answer;
    }

    private static int calculate(String[][] park, int[][] sizes, int i, int j) {
        if (i >= park.length || j >= park[0].length || !park[i][j].equals("-1")) return 0;
        if (sizes[i][j] != 0) return sizes[i][j];

        int size1 = calculate(park, sizes, i + 1, j);
        int size2 = calculate(park, sizes, i, j + 1);
        int size3 = calculate(park, sizes, i + 1, j + 1);

        sizes[i][j] = size1 < size2 ? (Math.min(size1, size3) + 1) : (Math.min(size2, size3) + 1);
        return sizes[i][j];
    }
}
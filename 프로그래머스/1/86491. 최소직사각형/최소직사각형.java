class Solution {
    public int solution(int[][] sizes) {
        int max1 = 0;
        int indexOfMaxIndex = 0;
        for (int i = 0; i < sizes.length; i++) {
            int value = Math.max(sizes[i][0], sizes[i][1]);
            if (max1 < value) {
                max1 = value;
                if (sizes[i][0] < sizes[i][1]) {
                    indexOfMaxIndex = 1;
                } else {
                    indexOfMaxIndex = 0;
                }
            }
        }
        
        int max2 = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (indexOfMaxIndex == 0) {
                if (sizes[i][1] > sizes[i][0]) {
                    int temp = sizes[i][1];
                    sizes[i][1] = sizes[i][0];
                    sizes[i][0] = temp;
                }
                if (max2 < sizes[i][1]) {
                    max2 = sizes[i][1];
                }
            } else {
                if (sizes[i][0] > sizes[i][1]) {
                    int temp = sizes[i][1];
                    sizes[i][1] = sizes[i][0];
                    sizes[i][0] = temp;
                }
                if (max2 < sizes[i][0]) {
                    max2 = sizes[i][0];
                }
            }
        }
        
        return max1 * max2;
    }
}
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int m = arr1[i] | arr2[i];
            answer[i] = "";
            for (int j = 0; j < n; j++) {
                if (m % 2 == 0) {
                    answer[i] = " " + answer[i];
                } else {
                    answer[i] = "#" + answer[i];
                }
                m /= 2;
            }
        }
        return answer;
    }
}
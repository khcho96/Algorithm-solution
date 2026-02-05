class Solution {
    public static String solution(int n) {
        int sum = 0;
        int repeat = 0;
        for (int i = 1; i <= 16; i++) {
            sum += (int) Math.pow(3, i);
            if (n <= sum) {
                repeat = i;
                sum -= (int) Math.pow(3, i);
                break;
            }
        }

        StringBuilder answer = new StringBuilder();
        n -= sum;
        for (int i = repeat - 1; i >= 0; i--) {
            int pow = (int) Math.pow(3, i);
            int order = (n - 1) / pow;

            if (order == 0) answer.append("1");
            else if (order == 1) answer.append("2");
            else answer.append("4");

            n = (n - 1) % pow + 1;
        }

        return answer.toString();
    }
}

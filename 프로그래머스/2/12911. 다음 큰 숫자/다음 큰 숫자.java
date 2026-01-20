class Solution {
    public int solution(int n) {
        int answer = 0;
        int count1 = getCount(n);
        for (int i = n + 1; i <= 1000000; i++) {
            int count2 = getCount(i);

            if (count1 == count2) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    private static int getCount(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) count++;

            n /= 2;
        }
        return count;
    }
}
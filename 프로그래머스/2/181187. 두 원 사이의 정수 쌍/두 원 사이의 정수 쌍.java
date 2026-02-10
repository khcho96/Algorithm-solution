class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (long x = 1; x <= r1; x++) answer += (long) Math.floor(Math.sqrt((long) r2 * (long) r2 - x * x)) - (long) Math.ceil(Math.sqrt((long) r1 * (long) r1 - x * x)) + 1;
        for (long x = r1 + 1; x < r2; x++) answer += (long) Math.floor(Math.sqrt((long) r2 * (long) r2 - x * x)) + 1;
        return (answer + 1) * 4;
    }
}

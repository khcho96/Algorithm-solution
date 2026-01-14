class Solution {
    public long solution(int price, int money, int count) {
        long lack = (count * (count + 1) / 2) * (long) price - (long) money;
        if (lack <= 0) return 0;
        return lack;
    }
}
class Solution {
    public int solution(int storey) {
        return func(storey);
    }
    
    private static int func(int storey) {
        if (storey == 0) return 0;
        if (storey == 1) return 1;

        int i = storey % 10;
        if (i == 0) return func(storey / 10);
        return Math.min(func((storey - i) / 10) + i, func((storey + 10 - i)/ 10) + 10 - i);
    }
}
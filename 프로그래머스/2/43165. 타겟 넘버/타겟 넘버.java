class Solution {
    public int solution(int[] numbers, int target) {
        return func(0, numbers, 0, target);
    }

    private int func(int i, int[] numbers, int value, int target) {
        if (i == numbers.length) return value == target ? 1 : 0;
        return func(i + 1, numbers, value + numbers[i], target) + func(i + 1, numbers, value - numbers[i], target);
    }
}

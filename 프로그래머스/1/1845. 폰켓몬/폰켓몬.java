import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int count = (int) Arrays.stream(nums)
                .distinct()
                .count();

        if (nums.length / 2 >= count) {
            return count;
        } else {
            return nums.length / 2;
        }
    }
}
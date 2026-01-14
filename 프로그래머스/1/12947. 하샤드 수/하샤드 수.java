import java.util.*;

class Solution {
    public boolean solution(int x) {
        int sum = Arrays.stream(String.valueOf(x).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
        
        if (x % sum == 0) {
            return true;
        } else {
            return false;
        }
    }
}
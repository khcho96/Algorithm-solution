class Solution {
    boolean solution(String s) {
        String lowerCase = s.toLowerCase();
        long countP = lowerCase.chars()
                .filter(c -> c == 'p')
                .count();
        long countY = lowerCase.chars()
                .filter(c -> c == 'y')
                .count();
        
        if (countP == countY) {
            return true;
        }
        
        return false;
    }
}
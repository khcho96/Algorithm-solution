class Solution {
    public String solution(String s) {
        int midIndex = s.length() / 2;
        
        if (s.length() % 2 == 0) {
            return s.substring(midIndex - 1, midIndex + 1);
        } 
        return s.substring(midIndex, midIndex + 1);
    }
}
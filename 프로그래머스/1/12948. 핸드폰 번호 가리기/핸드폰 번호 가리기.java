class Solution {
    public String solution(String phone_number) {
        String prefix = phone_number.substring(0, phone_number.length()-4);
        String suffix = phone_number.substring(phone_number.length() - 4);
        
        return "*".repeat(prefix.length()) + suffix;
    }
}
class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();

        new_id = new_id.replaceAll("[^[a-z]\\d-_.]", "");

        new_id = new_id.replaceAll("\\.\\.+", ".");

        new_id = new_id.replaceAll("^\\.", "");
        new_id = new_id.replaceAll("\\.$", "");

        new_id = new_id.isBlank() ? "a" : new_id;

        new_id = new_id.length() >= 16 ? new_id.substring(0, 15) : new_id;
        new_id = new_id.replaceAll("\\.$", "");

        StringBuilder stringBuilder = new StringBuilder(new_id);
        new_id = stringBuilder.length() <= 2 ? stringBuilder.append(stringBuilder.charAt(stringBuilder.length()-1)).toString() : new_id;
        new_id = stringBuilder.length() <= 2 ? stringBuilder.append(stringBuilder.charAt(stringBuilder.length()-1)).toString() : new_id;
        
        return new_id;
    }
}
import java.util.*;

class Solution {

    public String solution(String p) {
        return func(p);
    }

    private String func(String p) {
        if (p.isBlank()) return p;

        int open = 0, close = 0;
        int index = 0;
        do {
            if (p.charAt(index++) == '(') open++;
            else close++;
        } while (open != close);

        String u = p.substring(0, index);
        String v = p.substring(index);

        if (isRight(u)) return u + func(v);
        return "(" + func(v) + ")" + getReverse(u.substring(1, u.length() - 1));
    }

    private boolean isRight(String u) {
        Deque<String> stack = new ArrayDeque<>();
        for (String s : u.split("")) {
            if (s.equals("(")) stack.addLast(s);
            else {
                if (stack.isEmpty()) return false;
                if (!stack.removeLast().equals("(")) return false;
            }
        }

        return true;
    }

    private String getReverse(String substring) {
        if (substring.isBlank()) return substring;
        
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : substring.split("")) {
            if (s.equals("(")) stringBuilder.append(")");
            else stringBuilder.append("(");
        }
        return stringBuilder.toString();
    }
}

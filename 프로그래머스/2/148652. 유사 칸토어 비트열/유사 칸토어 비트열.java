class Solution {
    public int solution(int n, long l, long r) {
        String string = "11011";
        if (n == 1) {
            return string.substring((int) (l - 1), (int) r).replaceAll("0", "").length();
        }

        long[] left = new long[n + 1];
        long[] right = new long[n + 1];
        left[n] = l - 1;
        right[n] = r - 1;
        for (int i = n - 1; i >= 1; i--) {
            left[i] = left[i + 1] / 5;
            right[i] = right[i + 1] / 5;
        }

        for (int i = 1; i < n; i++) {
            String substring = string.substring((int) left[i], (int) right[i] + 1);
            string = getString(substring);

            long min = (left[i + 1] / 5) * 5;
            left[i + 1] = left[i + 1] - min;
            right[i + 1] = right[i + 1] - min;
        }

        return string.substring((int) left[n], (int) right[n] + 1).replaceAll("0", "").length();
    }

    private static String getString(String substring) {
        StringBuilder string = new StringBuilder();
        for (String s : substring.split("")) {
            if (s.equals("0")) {
                string.append("00000");
            } else {
                string.append("11011");
            }
        }
        return string.toString();
    }
}
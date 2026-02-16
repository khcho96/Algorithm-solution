class Solution {
    public long solution(int w, int h) {
        long W = w, H = h;
        long g = gcd(W, H);
        return W * H - (W + H - g);
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

// g = gcd(w, h) -> 유클리드 호제법
// 못 쓰는 칸 = g * (w/g + h/g - 1) = w + h - g
import java.util.*;

class Solution {

    public int solution(int[] diffs, int[] times, long limit) {
        // level이 maxDiff 이상이면 모든 스테이지가 "한 번에 통과"가 되므로
        // 최소 정답은 [1, maxDiff] 안에 있음
        int lo = 1;
        int hi = 0;
        for (int d : diffs) hi = Math.max(hi, d);

        // 이분 탐색: lo..hi 사이에서 "가능해지는 최초 level" 찾기
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (can(mid, diffs, times, limit)) hi = mid;        // mid도 가능 -> 더 낮은 답이 있는지 왼쪽
            else lo = mid + 1;    // mid는 불가능 -> 더 높은 level 필요
        }

        return lo;
    }

    private boolean can(int level, int[] diffs, int[] times, long limit) {
        long sum = 0;
        for (int i = 0; i < diffs.length; i++) {
            sum += level >= diffs[i] ? times[i] : (long) (diffs[i] - level) * (times[i - 1] + times[i]) + times[i];
            if (sum > limit) return false;
        }
        
        return true;
    }
}

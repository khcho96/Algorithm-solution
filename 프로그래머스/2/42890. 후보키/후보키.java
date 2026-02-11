import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;

        List<Integer> candidateKeys = new ArrayList<>(); // 후보키를 비트마스크로 저장

        for (int mask = 1; mask < (1 << col); mask++) {

            // 1) 최소성 체크: 기존 후보키가 부분집합이면 스킵
            boolean minimal = true;
            for (int key : candidateKeys) {
                if ((mask & key) == key) { // key ⊆ mask
                    minimal = false;
                    break;
                }
            }
            if (!minimal) continue;

            // 2) 유일성 체크
            Set<String> seen = new HashSet<>();
            for (int r = 0; r < row; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < col; c++) {
                    if ((mask & (1 << c)) != 0) {
                        sb.append(relation[r][c]).append('|'); // 구분자 필수
                    }
                }
                seen.add(sb.toString());
            }

            if (seen.size() == row) { // 모든 행이 구분됨
                candidateKeys.add(mask);
            }
        }

        return candidateKeys.size();
    }
}

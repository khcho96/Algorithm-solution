import java.util.*;

class Solution {

    public int answer = 0;
    public String[][] relations;

    public int solution(String[][] relation) {
        relations = relation;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < relation[0].length; i++) list.add(i);
        boolean[] visited = new boolean[relation[0].length];
        Set<Set<Integer>> candidateKeys = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 1; i <= relation[0].length; i++) {
            func(visited, list, i, cur, candidateKeys, 0);
        }

        return answer;
    }

    private void func(boolean[] visited, List<Integer> list, int r, List<Integer> cur, Set<Set<Integer>> candidateKeys, int start) {
        if (r == 0) {
            List<Row> rows = new ArrayList<>();

            for (String[] relation : relations) {
                Row row = new Row();
                for (int integer : cur) row.add(relation[integer]);
                rows.add(row);
            }

            if (new HashSet<>(rows).size() == rows.size()) {
                Set<Integer> set = new HashSet<>();
                for (Integer integer : cur) set.add(integer);

                for (Set<Integer> candidateKey : candidateKeys) {
                    if (set.containsAll(candidateKey)) return;
                }

                answer++;
                candidateKeys.add(set);
            }

            return;
        }

        for (Integer i = start; i < list.size(); i++) {
            visited[i] = true;
            cur.add(i);
            func(visited, list, r - 1, cur, candidateKeys, i + 1);
            cur.remove(i);
            visited[i] = false;
        }
    }

    public class Row {
        List<String> contents;

        public Row() {
            this.contents = new ArrayList<>();
        }

        public void add(String content) {
            contents.add(content);
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            Row row = (Row) object;
            return Objects.equals(contents, row.contents);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(contents);
        }
    }
}

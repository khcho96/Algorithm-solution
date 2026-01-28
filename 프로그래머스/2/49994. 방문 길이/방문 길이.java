import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Map<Coordinate, Set<Coordinate>> map = new HashMap<>();
        Coordinate cur = new Coordinate(0, 0);
        for (String string : dirs.split("")) {
            Coordinate next;
            if (string.equals("U")) {
                next = cur.up();
            } else if (string.equals("D")) {
                next = cur.down();
            } else if (string.equals("R")) {
                next = cur.right();
            } else {
                next = cur.left();
            }

            if (next == null) continue;

            if (!map.containsKey(cur) || !map.get(cur).contains(next)) {
                if (map.containsKey(cur)) map.get(cur).add(next);
                else map.put(cur, new HashSet<>(Set.of(next)));

                if (map.containsKey(next)) map.get(next).add(cur);
                else map.put(next, new HashSet<>(Set.of(cur)));

                answer++;
            }

            cur = next;
        }
        
        return answer;
    }

    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            Coordinate that = (Coordinate) object;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Coordinate up() {
            if (y + 1 > 5) {
                return null;
            }
            return new Coordinate(x, y + 1);
        }

        public Coordinate down() {
            if (y - 1 < -5) {
                return null;
            }
            return new Coordinate(x, y - 1);
        }

        public Coordinate right() {
            if (x + 1 > 5) {
                return null;
            }
            return new Coordinate(x + 1, y);
        }

        public Coordinate left() {
            if (x - 1 < -5) {
                return null;
            }
            return new Coordinate(x - 1, y);
        }
    }
}
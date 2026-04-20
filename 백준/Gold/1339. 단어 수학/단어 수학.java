import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static int N;
    static Map<String, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            int a = 1;
            for (int j = split.length - 1; j >= 0; j--) {
                map.put(split[j], map.getOrDefault(split[j], 0L) + a);
                a *= 10;
            }
        }

        int num = 9;
        long answer = 0;
        long max;
        String maxKey = "";
        while (!map.isEmpty()) {
            max = 0;
            for (String s : map.keySet()) {
                if (max <= map.get(s) * num) {
                    max = map.get(s) * num;
                    maxKey = s;
                }
            }
            answer += max;
            num--;
            map.remove(maxKey);
        }

        System.out.println(answer);
    }
}

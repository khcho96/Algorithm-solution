import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

class Main {

    static int N;
    static Set<Integer> set = Set.of(1, 2, 3);
    static int count;
    static StringBuilder orders = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        func(1, 3, N);

        System.out.println(count);
        System.out.println(orders);
    }

    private static void func(int from, int to, int n) {
        if (n == 1) {
            orders.append(from).append(" ").append(to).append("\n");
            count++;
            return;
        }

        int bridge = getBridge(from, to);
        func(from, bridge, n - 1);
        orders.append(from).append(" ").append(to).append("\n");
        count++;
        func(bridge, to, n - 1);
    }

    private static int getBridge(int from, int to) {
        int bridge = 0;
        for (Integer i : set) {
            if (i != from && i != to) {
                bridge = i;
                break;
            }
        }
        return bridge;
    }
}

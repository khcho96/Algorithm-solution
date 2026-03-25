import java.io.*;
import java.util.*;

class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (isPrime(arr[i])) answer++;
        }
        System.out.println(answer);
    }

    private static boolean isPrime(int k) {
        if (k == 1) return false;

        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) return false;
        }

        return true;
    }
}

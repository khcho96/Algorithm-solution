import java.io.*;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sizes = new int[6];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(split[i]);
        }

        String[] split1 = br.readLine().split(" ");
        int T = Integer.parseInt(split1[0]);
        int P = Integer.parseInt(split1[1]);

        int a = Arrays.stream(sizes)
                .filter(size -> size != 0)
                .map(size -> (size - 1) / T + 1)
                .sum();
        System.out.println(a);
        System.out.println(N / P + " " + N % P);
    }
}

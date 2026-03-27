import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] split = br.readLine().split(" ");
            long a = Long.parseLong(split[0]);
            long b = Long.parseLong(split[1]);
            long c = Long.parseLong(split[2]);

            if (a == 0 && b == 0 && c == 0) break;

            if (a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}

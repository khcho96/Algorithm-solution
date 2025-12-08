import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] split = input.split(" ");

        int a = Integer.parseInt(split[0].strip());
        int b = Integer.parseInt(split[1].strip());

        System.out.println(a + b);
    }
}

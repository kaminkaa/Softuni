import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pokemon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());

        int power = n;
        int count = 0;

        while (true) {
            if (power < m) { break; }

            if (power == n/2 && y != 0) {
                power = power / y;
            }

            if (power < m) { break; }

            power -= m;
            count ++;
        }

        System.out.println(power);
        System.out.println(count);
    }
}

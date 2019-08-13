import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseChars
{
    public static void main(String[] args) throws IOException {
        char[] letters = new char[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            letters[i] = reader.readLine().charAt(0);
        }

        for (int i = 2; i >= 0; i--) {
            System.out.printf("%c",letters[i]);
        }
    }
}

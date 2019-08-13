import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String pattern = reader.readLine();

        StringBuilder sb = new StringBuilder(input);
        StringBuilder pat = new StringBuilder(pattern);

        int firstMatchIndex, lastMatchIndex;

        while (true) {

            if (sb.length() == 0 || pat.toString().isEmpty()) {
                break;
            }

            firstMatchIndex = sb.indexOf(pat.toString());
            lastMatchIndex = sb.lastIndexOf(pat.toString());

            if (lastMatchIndex == -1 || firstMatchIndex == -1 || firstMatchIndex == lastMatchIndex) {
                break;
            } else {
                sb.delete(lastMatchIndex, lastMatchIndex + pat.toString().length());
                sb.delete(firstMatchIndex, firstMatchIndex + pat.toString().length());
            }

                System.out.printf("Shaked it.\n");
                pat.deleteCharAt(pat.toString().length()/2);
        }

        System.out.printf("No shake.\n");

        System.out.println(sb.toString());
    }
}

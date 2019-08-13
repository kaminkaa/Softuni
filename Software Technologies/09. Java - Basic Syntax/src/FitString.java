import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FitString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder result;

        if (input.length() < 20){
            result = new StringBuilder(input);
            for (int i = input.length(); i < 20; i++){
                result.append('*');
            }
        } else {
            result = new StringBuilder(input.substring(0,20));
        }

        System.out.println(result.toString());
    }
}

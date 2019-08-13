import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VariableBoolean {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Boolean bool = Boolean.valueOf(reader.readLine());
        if (bool){
            System.out.printf("Yes");
        } else {
            System.out.printf("No");
        }
    }
}

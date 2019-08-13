import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        String str1 = input[0];
        String str2 = input[1];

        int length;
        boolean isLengthEqual = false;
        String longerStr = "";

        if (str1.length() == str2.length()){
            length = str1.length();
            isLengthEqual = true;
        } else {
            length = Math.min(str1.length(),str2.length());
            if (length == str1.length()){
                longerStr = str2;
            } else {
                longerStr = str1;
            }
        }

        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += (int)str1.charAt(i) * (int)str2.charAt(i);
        }

        if (!isLengthEqual){
            for (int i = length; i < Math.max(str1.length(), str2.length()); i++) {
                sum += (int)longerStr.charAt(i);
            }
        }

        System.out.println(sum);
    }
}

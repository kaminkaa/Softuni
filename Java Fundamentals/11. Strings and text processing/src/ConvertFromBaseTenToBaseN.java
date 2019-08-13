import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConvertFromBaseTenToBaseN {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        int base = Integer.parseInt(input[0]);
        BigInteger numberBaseTen = new BigInteger(input[1]);

        String result = "";
        BigInteger reminder;

        while (numberBaseTen.compareTo(BigInteger.valueOf(0)) > 0){
            reminder = numberBaseTen.remainder(BigInteger.valueOf(base));
            numberBaseTen = numberBaseTen.divide(BigInteger.valueOf(base));
            result = (char)('0' + reminder.intValue()) + result;
        }

        System.out.println(result);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConvertFromBaseNToBaseTen {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        int base = Integer.parseInt(input[0]);
        BigInteger numberBaseN = new BigInteger(input[1]);

        BigInteger reminder;
        BigInteger digitValue;
        BigInteger sum = new BigInteger("0");
        int index = 0;

        while (numberBaseN.compareTo(BigInteger.valueOf(0)) > 0){
            reminder = numberBaseN.remainder(BigInteger.valueOf(10));
            digitValue = reminder.multiply(BigInteger.valueOf(base).pow(index));

            sum = sum.add(digitValue);
            index ++;
            numberBaseN = numberBaseN.divide(BigInteger.valueOf(10));
        }

        System.out.println(sum);
    }
}

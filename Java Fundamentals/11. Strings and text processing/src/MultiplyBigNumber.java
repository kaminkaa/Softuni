import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String bigNumber = reader.readLine();
        int multiplier = Integer.parseInt(reader.readLine());

        String product = MultiplyNumbers(bigNumber, multiplier);
        System.out.println(product);
    }

    static String MultiplyNumbers (String number, int multiplier) {
        String product;

        if (multiplier == 0) {
            product = "0";
        } else if (multiplier == 1) {
            product = number;
        } else {
            product = SumNumbers(number, number);

            for (int i = 2; i < multiplier; i++) {
                product = SumNumbers(product, number);
            }
        }

        return product;
    }

    static String SumNumbers (String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int remainder = 0;

        int digit1, digit2;
        int sum;

        for (int i = 0; i <= Math.max(num1.length(), num2.length()) - 1; i++) {
            if (num1.length() - 1 - i >= 0) {
                digit1 = num1.charAt(num1.length() - 1 - i) - '0';
            } else {
                digit1 = 0;
            }

            if (num2.length() - 1 - i >= 0) {
                digit2 = num2.charAt(num2.length() - 1 - i) - '0';
            } else {
                digit2 = 0;
            }

            sum = digit1 + digit2 + remainder;

            if (sum > 9) {
                sb.append(sum%10);
                remainder = 1;
            } else {
                sb.append(sum);
                remainder = 0;
            }
        }

        if (remainder > 0) {
            sb.append(remainder);
        }

        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
                i--;
            } else {
                break;
            }
        }
        return sb.toString();
    }
}

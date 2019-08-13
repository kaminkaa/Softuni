import java.math.BigInteger;
import java.util.Scanner;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int num = Integer.parseInt(console.nextLine());

        BigInteger factorial = FindFactorial(num);
        String bigInt = String.valueOf(factorial);

        System.out.println(CountFactorialTrailingZeroes(bigInt));
    }

    static int CountFactorialTrailingZeroes (String bigInt){
        int count = 0;
        for (int i=bigInt.length()-1; i>0; i--){
            if (bigInt.charAt(i)=='0'){
                count ++;
            } else {
                break;
            }
        }
        return count;
    }

    static BigInteger FindFactorial (int num){
        BigInteger I;
        BigInteger result = BigInteger.valueOf(1);

        for (int i = num; i >=1; i--){
            I = BigInteger.valueOf(i);
            result = result.multiply(I);
        }
        return result;
    }
}

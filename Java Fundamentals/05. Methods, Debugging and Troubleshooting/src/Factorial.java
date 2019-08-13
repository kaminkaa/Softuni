import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int num = Integer.parseInt(console.nextLine());

        FindFactorial(num);
    }

    static void FindFactorial (int num){
        BigInteger I;
        BigInteger result = BigInteger.valueOf(1);

        for (int i = num; i >=1; i--){
            I = BigInteger.valueOf(i);
            result = result.multiply(I);
        }

        System.out.println(result);
    }
}

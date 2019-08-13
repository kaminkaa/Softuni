import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class PrimeChecker {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = Long.parseLong(console.nextLine());

        if (IsPrime(n)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    static boolean IsPrime (long n) {
        boolean check = true;

        if (n==0 || n==1){
            check = false;
            return  check;
        }

        for (long i = 2; i<=Math.sqrt(n); i++){
            if (n%i==0){
                check = false;
                break;
            }
        }

        return check;
    }
}

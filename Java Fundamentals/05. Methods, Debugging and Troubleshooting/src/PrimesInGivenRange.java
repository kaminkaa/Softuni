import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class PrimesInGivenRange {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int start = Integer.parseInt(console.nextLine());
        int end = Integer.parseInt(console.nextLine());

        PrintPrimeNumbers(FindPrimesInRange(start,end));
    }

    static void PrintPrimeNumbers (List<Integer> primeNumbers){
        for(int i = 0; i < primeNumbers.size(); i++) {
            if (i == primeNumbers.size()-1){
                System.out.print(primeNumbers.get(i).toString());
                break;
            }
            System.out.print(primeNumbers.get(i).toString() + ", ");
        }
    }

    static List<Integer> FindPrimesInRange (int start, int end){
        List<Integer> primeNumbers = new ArrayList<Integer>();

        for (int i=start; i<=end; i++){
            if (IsPrime(i)){
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    static boolean IsPrime (long n) {
        boolean check = true;

        if (n==0 || n==1){
            check = false;
        }

        for (long i = 2; i<n; i++){
            if (n%i==0){
                check = false;
                break;
            }
        }
        return check;
    }
}

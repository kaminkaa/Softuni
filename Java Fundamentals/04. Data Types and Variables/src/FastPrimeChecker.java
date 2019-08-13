import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class FastPrimeChecker {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        boolean check;

        for (int i = 2; i<=n; i++){
            check = true;
            for (int j=2; j<i; j++){
                if (i%j==0){
                   check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(i + " -> True");
            } else {
                System.out.println(i + " -> False");
            }
        }
    }
}

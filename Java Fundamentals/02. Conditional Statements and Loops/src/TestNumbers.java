import java.util.Scanner;

/**
 * Created by Cammi on 24/09/2017.
 */
public class TestNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        int m = Integer.parseInt(console.nextLine());
        int maxsum = Integer.parseInt(console.nextLine());

        int sum = 0;
        int count = 0;

        for (int i=n; i>=1; i--){
            if (sum>=maxsum){
                break;
            }

            for (int j=1; j<=m; j++){
                sum += i*j*3;
                count++;
                if (sum>=maxsum){
                    break;
                }
            }
        }

        if (sum<maxsum) {
            System.out.println(count + " combinations");
            System.out.println("Sum: " + sum);
        } else {
            System.out.println(count + " combinations");
            System.out.println("Sum: " + sum + " >= " + maxsum);
        }
    }
}

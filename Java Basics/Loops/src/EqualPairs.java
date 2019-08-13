import java.util.Scanner;

/**
 * Created by Cammi on 20/07/2017.
 */
public class EqualPairs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        int sum = 0;
        int prevSum =0;
        int number1, number2;
        int sumDiff;
        int maxDiff = -10000;

        if(n==1){
            number1 = Integer.parseInt(console.nextLine());
            number2 = Integer.parseInt(console.nextLine());
            sum = number1 + number2;
            maxDiff =0;
        } else {
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    prevSum = sum;
                }
                number1 = Integer.parseInt(console.nextLine());
                number2 = Integer.parseInt(console.nextLine());
                sum = number1 + number2;
                if (i != 0) {
                    sumDiff = Math.abs(sum - prevSum);
                    if (sumDiff > maxDiff) {
                        maxDiff = sumDiff;
                    }
                }
            }
        }

        if(maxDiff==0){
            System.out.println("Yes, value = "+sum);
        } else {
            System.out.println("No, maxdiff = "+maxDiff);
        }
    }
}

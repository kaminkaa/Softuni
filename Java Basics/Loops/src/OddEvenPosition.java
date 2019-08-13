import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Cammi on 20/07/2017.
 */
public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        double oddSum = 0.0;
        double oddMin = 10000;
        double oddMax = -10000;
        double evenSum = 0.0;
        double evenMin = 10000;
        double evenMax = -10000;

        double number;

        for(int i=1; i<=n; i++){
            number = Double.parseDouble(console.nextLine());
            if(i%2==0){
                evenSum += number;
                if(number>evenMax){
                    evenMax = number;
                }
                if(number<evenMin){
                    evenMin = number;
                }
            } else {
                oddSum += number;
                if(number>oddMax){
                    oddMax = number;
                }
                if(number<oddMin){
                    oddMin = number;
                }
            }
        }

        DecimalFormat df = new DecimalFormat("##.##");

        System.out.printf("OddSum = %s \n", df.format(oddSum));
        if (oddMin != 10000){
            System.out.printf("OddMin = %s \n",df.format(oddMin));
        } else {
            System.out.printf("OddMin = No \n");
        }
        if (oddMax != -10000){
            System.out.printf("OddMax = %s \n",df.format(oddMax));
        } else {
            System.out.printf("OddMax = No \n");
        }
        System.out.printf("EvenSum = %s \n",df.format(evenSum));
        if (evenMin != 10000){
            System.out.printf("EvenMin = %s \n",df.format(evenMin));
        } else {
            System.out.printf("EvenMin = No \n");
        }
        if (evenMax != -10000){
            System.out.printf("EvenMax = %s \n",df.format(evenMax));
        } else {
            System.out.printf("EvenMax = No \n");
        }

    }
}

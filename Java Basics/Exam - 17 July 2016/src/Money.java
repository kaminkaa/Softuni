import java.util.Scanner;

/**
 * Created by Cammi on 22/07/2017.
 */
public class Money {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int bitcoins = Integer.parseInt(console.nextLine());
        double ioans = Double.parseDouble(console.nextLine());
        double comission = Double.parseDouble(console.nextLine());

        double bitToBgn = bitcoins*1168;
        double bgnToEur = bitToBgn/1.95;

        double ioanToUsd = ioans*0.15;
        double usdToBgn = ioanToUsd*1.76;
        double bgnToEur2 = usdToBgn/1.95;

        double eurSum = bgnToEur+bgnToEur2;
        double result = eurSum-(eurSum*comission/100);

        System.out.printf("%.2f",result);
    }
}

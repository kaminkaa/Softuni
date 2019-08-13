import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Cammi on 02/10/2017.
 */
public class CenturiesToNanoseconds {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int century = Integer.parseInt(console.nextLine());

        int years = century*100;
        double days = years*365.2422;
        int dayss = (int)days;
        int hours = (int)days*24;
        long minutes = hours*60;
        long seconds = minutes*60;
        long milliseconds = seconds*1000;
        long microseconds = milliseconds*1000;
        BigInteger us = BigInteger.valueOf(microseconds);
        BigInteger thousand = BigInteger.valueOf(1000);
        BigInteger nanoseconds = us.multiply(thousand);

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes = %d seconds = %d milliseconds = %d microseconds = %d nanoseconds", century, years, dayss, hours,
                minutes, seconds, milliseconds, microseconds, nanoseconds);
    }
}

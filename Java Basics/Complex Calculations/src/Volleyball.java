import java.util.Scanner;

/**
 * Created by Cammi on 19/07/2017.
 */
public class Volleyball {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String year = console.nextLine();
        int p = Integer.parseInt(console.nextLine());
        int h = Integer.parseInt(console.nextLine());

        double playInSofia = (3.0/4)*(48 - h);
        double playDuringHoliday = (2.0/3)*p;
        double daysToPlay = playInSofia + h + playDuringHoliday;

        if(year.equals("leap")){
            daysToPlay = daysToPlay + daysToPlay*0.15;
            System.out.println(Math.floor(daysToPlay));
        } else {
            System.out.println(Math.floor(daysToPlay));
        }
    }
}

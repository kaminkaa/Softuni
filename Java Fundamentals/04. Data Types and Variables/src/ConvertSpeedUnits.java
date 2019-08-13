import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Cammi on 02/10/2017.
 */
public class ConvertSpeedUnits {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int distancemeters = Integer.parseInt(console.nextLine());
        int hours = Integer.parseInt(console.nextLine());
        int minutes = Integer.parseInt(console.nextLine());
        int seconds = Integer.parseInt(console.nextLine());

        int timeseconds = hours*60*60 + minutes*60 + seconds;

        double ms = (double)distancemeters/timeseconds;
        double kh = ms*3.6;
        double mh = kh*0.62150402;

        DecimalFormat decformat = new DecimalFormat("###.######");
        decformat.setDecimalSeparatorAlwaysShown(false);

        System.out.println(decformat.format(ms));
        System.out.println(decformat.format(kh));
        System.out.println(decformat.format(mh));
    }
}

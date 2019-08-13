import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Cammi on 21/09/2017.
 */
public class BeverageLabels {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        int volume = Integer.parseInt(console.nextLine());
        int energy = Integer.parseInt(console.nextLine());
        int sugar = Integer.parseInt(console.nextLine());

        double multiplier = (double)volume/100;
        double kcal = energy*multiplier;
        double g = sugar*multiplier;

        System.out.printf("%dml %s:", volume,name);
        System.out.println();
        DecimalFormat decimalformat = new DecimalFormat("#.##");
        System.out.println(decimalformat.format(kcal)+"kcal, "+decimalformat.format(g)+"g sugars");
    }
}

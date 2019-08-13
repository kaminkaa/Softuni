import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class RectangleProperties {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double a = Double.parseDouble(console.nextLine());
        double b = Double.parseDouble(console.nextLine());

        double p = 2*a + 2*b;
        double s = a*b;
        double d = Math.sqrt(a*a + b*b);

        DecimalFormat decformat = new DecimalFormat("###.#############");
        decformat.setDecimalSeparatorAlwaysShown(false);

        System.out.println(decformat.format(p));
        System.out.println(decformat.format(s));
        System.out.println(decformat.format(d));
    }
}

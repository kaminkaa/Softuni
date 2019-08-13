import java.util.Scanner;

/**
 * Created by Cammi on 07/07/2017.
 */
public class InchesToCentimeters {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double inches = Double.parseDouble(console.nextLine());

        double cm = inches * 2.54;
        System.out.println(inches+" inches = "+cm+" centimeters");
    }
}

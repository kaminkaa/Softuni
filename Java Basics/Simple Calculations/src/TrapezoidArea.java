import java.util.Scanner;

/**
 * Created by Cammi on 11/07/2017.
 */
public class TrapezoidArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double b1 = Double.parseDouble(console.nextLine());
        double b2 = Double.parseDouble(console.nextLine());
        double h = Double.parseDouble(console.nextLine());

        System.out.println((b1+b2)*h/2);
    }
}

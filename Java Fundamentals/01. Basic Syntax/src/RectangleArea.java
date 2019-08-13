import java.util.Scanner;

/**
 * Created by Cammi on 21/09/2017.
 */
public class RectangleArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double a = Double.parseDouble(console.nextLine());
        double b = Double.parseDouble(console.nextLine());

        System.out.printf("%.2f", a*b);
    }
}

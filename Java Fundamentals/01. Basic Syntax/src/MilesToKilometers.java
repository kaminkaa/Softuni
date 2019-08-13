import java.util.Scanner;

/**
 * Created by Cammi on 21/09/2017.
 */
public class MilesToKilometers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double miles = Double.parseDouble(console.nextLine());

        System.out.printf("%.2f", miles*1.60934);
    }
}

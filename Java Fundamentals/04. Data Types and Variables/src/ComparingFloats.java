import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class ComparingFloats {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double a = Double.parseDouble(console.nextLine());
        double b = Double.parseDouble(console.nextLine());

        double eps = 0.000001;
        double difference = Math.abs(a-b);

        if (difference >= eps){
            System.out.printf("False");
        } else {
            System.out.printf("True");
        }
    }
}

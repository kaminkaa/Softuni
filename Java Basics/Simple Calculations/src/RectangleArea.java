import java.util.Scanner;

/**
 * Created by Cammi on 11/07/2017.
 */
public class RectangleArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double x1 = Double.parseDouble(console.nextLine());
        double y1 = Double.parseDouble(console.nextLine());
        double x2 = Double.parseDouble(console.nextLine());
        double y2 = Double.parseDouble(console.nextLine());

        System.out.println(Math.abs((x1-x2)*(y1-y2)));
        System.out.println(2*(Math.abs((x1-x2))+ Math.abs((y1-y2))));
    }
}

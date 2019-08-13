import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Cammi on 04/10/2017.
 */
public class CenterPoint {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double x1 = Double.parseDouble(console.nextLine());
        double y1 = Double.parseDouble(console.nextLine());
        double x2 = Double.parseDouble(console.nextLine());
        double y2 = Double.parseDouble(console.nextLine());

        ClosestPointToCenter(x1,y1,x2,y2);
    }

    static void ClosestPointToCenter (double x1, double y1, double x2, double y2) {
        double closestX;
        double closestY;

        if (Math.sqrt(x1*x1 + y1*y1)== Math.sqrt(x2*x2 + y2*y2)){
            closestX = x1;
            closestY = y1;
        } else if (Math.sqrt(x1*x1 + y1*y1)< Math.sqrt(x2*x2 + y2*y2)) {
            closestX = x1;
            closestY = y1;
        } else {
            closestX = x2;
            closestY = y2;
        }

        DecimalFormat decformat = new DecimalFormat("#.##########");
        decformat.setDecimalSeparatorAlwaysShown(false);
        System.out.println("(" + decformat.format(closestX) + ", " + decformat.format(closestY) + ")");
    }
}

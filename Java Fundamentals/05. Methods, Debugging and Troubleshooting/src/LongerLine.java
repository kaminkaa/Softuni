import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Cammi on 04/10/2017.
 */
public class LongerLine {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double x1 = Double.parseDouble(console.nextLine());
        double y1 = Double.parseDouble(console.nextLine());
        double X1 = Double.parseDouble(console.nextLine());
        double Y1 = Double.parseDouble(console.nextLine());
        double x2 = Double.parseDouble(console.nextLine());
        double y2 = Double.parseDouble(console.nextLine());
        double X2 = Double.parseDouble(console.nextLine());
        double Y2 = Double.parseDouble(console.nextLine());

        double line1 = LineLength(x1,y1,X1,Y1);
        double line2 = LineLength(x2,y2,X2,Y2);

        if (line1>=line2){
            ClosestPointToCenter(x1,y1,X1,Y1);
        } else {
            ClosestPointToCenter(x2,y2,X2,Y2);
        }

    }

    static double LineLength(double x1, double y1, double x2, double y2)
    {
        double lineLength = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return lineLength;
    }

    static void ClosestPointToCenter (double x1, double y1, double x2, double y2) {
        double closestX, closestY, secondX, secondY;

        if (Math.abs(x1) == Math.abs(x2) && Math.abs(y1) == Math.abs(y2)){
            closestX = x1;
            closestY = y1;
            secondX = x1;
            secondY = y1;
        } else if (Math.abs(x1) < Math.abs(x2) && Math.abs(y1) < Math.abs(y2)) {
            closestX = x1;
            closestY = y1;
            secondX = x2;
            secondY = y2;
        } else {
            closestX = x2;
            closestY = y2;
            secondX = x1;
            secondY = y1;
        }

        DecimalFormat decformat = new DecimalFormat("#.##########");
        decformat.setDecimalSeparatorAlwaysShown(false);
        System.out.print("(" + decformat.format(closestX) + ", " + decformat.format(closestY) + ")");
        System.out.print("(" + decformat.format(secondX) + ", " + decformat.format(secondY) + ")");
    }
}


import java.util.Scanner;

/**
 * Created by Cammi on 19/07/2017.
 */
public class AreaofFigures {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String figure = console.nextLine();

        double area = 0;

        if(figure.equals("square")){
            double a = Double.parseDouble(console.nextLine());
            area = a*a;
        } else if (figure.equals("rectangle")){
            double a = Double.parseDouble(console.nextLine());
            double b = Double.parseDouble(console.nextLine());
            area = a*b;
        } else if (figure.equals("circle")){
            double r = Double.parseDouble(console.nextLine());
            area = Math.PI * r * r;
        } else if (figure.equals("triangle")){
            double a = Double.parseDouble(console.nextLine());
            double h = Double.parseDouble(console.nextLine());
            area = a * h / 2;
        }

        System.out.printf("%.3f",area);
    }
}

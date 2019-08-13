import java.util.Scanner;

public class GeometryCalculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String figure = console.nextLine().toLowerCase();

        double area = 0;
        double side, width, height, radius;

        switch (figure){

            case "triangle":
                side = Double.parseDouble(console.nextLine());
                height = Double.parseDouble(console.nextLine());
                area = CalculateFigureArea(figure,side,height);
                break;

            case  "square":
                side = Double.parseDouble(console.nextLine());
                area = CalculateFigureArea(figure,side,0);
                break;

            case "rectangle":
                width = Double.parseDouble(console.nextLine());
                height = Double.parseDouble(console.nextLine());
                area = CalculateFigureArea(figure,width,height);
                break;

            case "circle":
                radius = Double.parseDouble(console.nextLine());
                area = CalculateFigureArea(figure,radius,0);
                break;

            default:
                break;
        }

        System.out.printf("%.2f", area);
    }

    static double CalculateFigureArea (String figure, double s, double h){
        double area;

        switch (figure){

            case "triangle":
                area = s*h/2;
                break;

            case  "square":
                area = s*s;
                break;

            case "rectangle":
                area = s*h;
                break;

            case "circle":
                area = Math.PI*s*s;
                break;

            default: area = 0;
            break;
        }
        return area;
    }
}

import java.util.Scanner;

public class CubeProperties {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double side = Double.parseDouble(console.nextLine());
        String parameter = console.nextLine();

        System.out.printf("%.2f", CalculateCubeProperty(side,parameter));
    }

    static double CalculateCubeProperty (double side, String parameter){
        double result;

        switch (parameter){
            case "face": result = Math.sqrt(2*side*side);
            break;
            case "space": result = Math.sqrt(3*side*side);
            break;
            case "volume": result = side*side*side;
            break;
            case "area": result = 6*side*side;
            break;
            default: result = 0;
            break;
        }

        return result;
    }
}

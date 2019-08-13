import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] parameters = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Circle circle1 = new Circle();
        circle1.center.x = parameters[0];
        circle1.center.y = parameters[1];
        circle1.radius = parameters[2];

        parameters = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Circle circle2 = new Circle();
        circle2.center.x = parameters[0];
        circle2.center.y = parameters[1];
        circle2.radius = parameters[2];

        if (Intersect(circle1,circle2)){
            System.out.printf("Yes");
        } else {
            System.out.printf("No");
        }
    }

    static boolean Intersect(Circle c1, Circle c2){
        boolean ifIntersect = false;

        double d = Math.sqrt(Math.pow((c1.center.y - c2.center.y),2)
                              + Math.pow((c1.center.x - c2.center.x),2));

        if (d <= c1.radius + c2.radius){
            ifIntersect = true;
        }

        return ifIntersect;
    }
}

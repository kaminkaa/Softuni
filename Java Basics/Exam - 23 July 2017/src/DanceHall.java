import java.util.Scanner;

/**
 * Created by Cammi on 23/07/2017.
 */
public class DanceHall {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double l = Double.parseDouble(console.nextLine());
        double w = Double.parseDouble(console.nextLine());
        double a = Double.parseDouble(console.nextLine());

        double hallArea = l*100*w*100;
        double wardrobeArea = a*100*a*100;
        double benchArea = hallArea/10;

        double freeArea = hallArea-wardrobeArea-benchArea;
        double dancers = freeArea/7040;
        int numberOfDancers = (int)dancers;

        System.out.println(numberOfDancers);
    }
}

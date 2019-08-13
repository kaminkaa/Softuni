package ExamPreparation.HornetExam;
import java.util.*;
public class HornetWings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wingFlaps = Integer.parseInt(scan.nextLine());
        double metersFor1000flaps = Double.parseDouble(scan.nextLine());
        int endurance = Integer.parseInt(scan.nextLine());

        double distanceTravelled = (wingFlaps/1000)*metersFor1000flaps;
        int time = wingFlaps/100 + (wingFlaps/endurance)*5;

        System.out.printf("%.2f m.%n", distanceTravelled);
        System.out.printf("%d s.%n", time);
    }
}
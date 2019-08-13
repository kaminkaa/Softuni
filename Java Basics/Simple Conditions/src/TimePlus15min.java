import java.util.Scanner;

/**
 * Created by Cammi on 19/07/2017.
 */
public class TimePlus15min {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int hours = Integer.parseInt(console.nextLine());
        int minutes = Integer.parseInt(console.nextLine());

        if((minutes+15)>59){
            hours++;
            if(hours>23){
                hours = 0;
            }
            minutes = (minutes+15)-60;
        } else {
            minutes += 15;
        }

        if(minutes<10){
            System.out.printf("%d:0%d", hours, minutes);
        } else {
            System.out.printf("%d:%d", hours, minutes);
        }
    }
}

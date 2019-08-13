import java.util.Scanner;

/**
 * Created by Cammi on 23/07/2017.
 */
public class Choreography {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int steps = Integer.parseInt(console.nextLine());
        int dancers = Integer.parseInt(console.nextLine());
        int days = Integer.parseInt(console.nextLine());

        double stepsPerDay = (double)steps/(double)days;
        double stepsPercent = Math.ceil(stepsPerDay/steps*100);
        double stepsPercentPerDancer = stepsPercent/dancers;

        if(stepsPercent <= 13){
            System.out.printf("Yes, they will succeed in that goal! %.2f%%.", stepsPercentPerDancer);
        } else {
            System.out.printf("No, They will not succeed in that goal! Required %.2f%% steps to be learned per day.", stepsPercentPerDancer);
        }

    }
}

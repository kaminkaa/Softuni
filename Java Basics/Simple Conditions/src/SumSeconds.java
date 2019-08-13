import java.util.Scanner;

/**
 * Created by Cammi on 19/07/2017.
 */
public class SumSeconds {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int contestant1 = Integer.parseInt(console.nextLine());
        int contestant2 = Integer.parseInt(console.nextLine());
        int contestant3 = Integer.parseInt(console.nextLine());

        int secondsSum = contestant1 + contestant2 + contestant3;

        int minutes;
        int seconds;

        if(secondsSum<60){
            minutes = 0;
            seconds = secondsSum;
        } else if (secondsSum==60){
            minutes = 1;
            seconds = 0;
        } else if (secondsSum>60 && secondsSum<120){
            minutes = 1;
            seconds = secondsSum - 60;
        } else if (secondsSum==120){
            minutes = 2;
            seconds = 0;
        } else {
            minutes = 2;
            seconds = secondsSum - 120;
        }

        if (seconds<10){
            System.out.printf("%d:0%d",minutes,seconds);
        } else {
            System.out.printf("%d:%d", minutes, seconds);
        }
    }
}

import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class TheaThePhotographer {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        int ft = Integer.parseInt(console.nextLine());
        int ff = Integer.parseInt(console.nextLine());
        int ut = Integer.parseInt(console.nextLine());

        int filtertimeseconds = n*ft;
        double usefulpictures = Math.ceil((double)n*ff/100);
        int usefulpicturess = (int)usefulpictures;
        int uploadtimeseconds = usefulpicturess*ut;
        int totaltimeseconds = filtertimeseconds + uploadtimeseconds;

        int days = 0;
        int hours = 0;
        int minutes = 0;
        int secodns = 0;

        minutes = totaltimeseconds/60;
        secodns = totaltimeseconds%60;

        while (minutes>59) {
            hours++;
            minutes = minutes-60;
        }

        while (hours>23) {
            days++;
            hours = hours - 24;
        }

        if (days==0){
            System.out.printf("0:");
        } else {
            System.out.printf("%d:",days);
        }

        if (hours==0){
            System.out.printf("00:");
        } else if (hours<10){
            System.out.printf("0%d:",hours);
        } else {
            System.out.printf("%d:",hours);
        }

        if (minutes==0){
            System.out.printf("00:");
        } else if (minutes<10){
            System.out.printf("0%d:",minutes);
        } else {
            System.out.printf("%d:",minutes);
        }

        if (secodns==0){
            System.out.printf("00");
        } else if (secodns<10){
            System.out.printf("0%d",secodns);
        } else {
            System.out.printf("%d",secodns);
        }
    }
}

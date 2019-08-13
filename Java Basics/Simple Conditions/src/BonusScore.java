import java.util.Scanner;

/**
 * Created by Cammi on 18/07/2017.
 */
public class BonusScore {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());

        double bonusScore = 0;
        double totalScore = 0;

        if(number>1000){
            bonusScore = number*0.1;
        } else if (number>100){
            bonusScore = number*0.2;
        } else if (number <= 100){
            bonusScore = 5;
        }

        if(number%2==0){
            bonusScore = bonusScore + 1;
        } else if (number%5==0){
            bonusScore = bonusScore + 2;
        }

        totalScore = number + bonusScore;

        System.out.println(bonusScore);
        System.out.println(totalScore);
    }
}

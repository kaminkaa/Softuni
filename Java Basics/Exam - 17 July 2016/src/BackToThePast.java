import java.util.Scanner;

/**
 * Created by Cammi on 22/07/2017.
 */
public class BackToThePast {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double money = Double.parseDouble(console.nextLine());
        int year = Integer.parseInt(console.nextLine());

        double spends = 0;
        int count = 1;
        double remaining = money;

        for (int i=1800; i<=year; i++){
            if(i%2==0){
                spends = 12000;
                remaining = remaining - spends;
            } else {
                spends = 12000 + 50*(18+count);
                count += 2;
                remaining = remaining - spends;
            }
        }

        if(remaining>=0){
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.",remaining);
        } else {
            System.out.printf("He will need %.2f dollars to survive.",Math.abs(remaining));
        }
    }
}

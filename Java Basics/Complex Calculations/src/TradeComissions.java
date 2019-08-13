import java.util.Scanner;

/**
 * Created by Cammi on 19/07/2017.
 */
public class TradeComissions {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String city = console.nextLine().toLowerCase();
        double s = Double.parseDouble(console.nextLine());

        double comission = -1;
        double commisionCalculated = 0;

        if (city.equals("sofia")){
            if(s>=0 && s <=500){
                comission = 0.05;
            } else if (s>500 && s<=1000){
                comission = 0.07;
            } else if (s>1000 && s<=10000){
                comission = 0.08;
            } else if (s>10000){
                comission = 0.12;
            }
        } else if (city.equals("varna")){
            if(s>=0 && s <=500){
                comission = 0.045;
            } else if (s>500 && s<=1000){
                comission = 0.075;
            } else if (s>1000 && s<=10000){
                comission = 0.1;
            } else if (s>10000){
                comission = 0.13;
            }
        } else if (city.equals("plovdiv")) {
            if (s >= 0 && s <= 500) {
                comission = 0.055;
            } else if (s > 500 && s <= 1000) {
                comission = 0.08;
            } else if (s > 1000 && s <= 10000) {
                comission = 0.12;
            } else if (s > 10000) {
                comission = 0.145;
            }
        }
            if(comission != -1){
                commisionCalculated = s*comission;
                System.out.printf("%.2f",commisionCalculated);
            } else {
                System.out.printf("error");
            }
    }
}

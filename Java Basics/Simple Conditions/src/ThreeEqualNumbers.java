import java.util.Scanner;

/**
 * Created by Cammi on 19/07/2017.
 */
public class ThreeEqualNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number1 = Integer.parseInt(console.nextLine());
        int number2 = Integer.parseInt(console.nextLine());
        int number3 = Integer.parseInt(console.nextLine());

        if(number1==number2 && number2==number3){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}

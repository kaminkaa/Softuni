import java.util.Scanner;

/**
 * Created by Cammi on 18/07/2017.
 */
public class GreaterNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number1 = Integer.parseInt(console.nextLine());
        int number2 = Integer.parseInt(console.nextLine());

        if(number1>=number2){
            System.out.println(number1);
        } else {
            System.out.println(number2);
        }
    }
}

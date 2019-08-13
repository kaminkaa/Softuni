import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class NumberReversedOrder {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String inputNumber = console.nextLine();
        PrintDigitsInReversedOrder(inputNumber);
    }

    public static void PrintDigitsInReversedOrder (String number){
        String result = "";
        for (int i = number.length()-1; i >=0; i--){
            result += number.charAt(i);
        }
        System.out.println(result);
    }
}

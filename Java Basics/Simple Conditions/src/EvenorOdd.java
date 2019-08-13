import java.util.Scanner;

/**
 * Created by Cammi on 18/07/2017.
 */
public class EvenorOdd {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());

        if(number%2==0){
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}

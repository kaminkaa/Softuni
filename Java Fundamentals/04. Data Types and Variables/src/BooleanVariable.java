import java.util.Scanner;

/**
 * Created by Cammi on 02/10/2017.
 */
public class BooleanVariable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();

        boolean bool = Boolean.parseBoolean(input);
        if (bool){
            System.out.printf("Yes");
        } else {
            System.out.printf("No");
        }
    }
}

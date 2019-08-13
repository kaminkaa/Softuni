import java.util.Scanner;

/**
 * Created by Cammi on 24/09/2017.
 */
public class CountTheIntegers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int count = 0;

        while (console.hasNextInt()){
            count++;
            console.next();
        }

        System.out.println(count);
    }
}

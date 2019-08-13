import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int input = Integer.parseInt(console.nextLine());

        System.out.println(Integer.toHexString(input).toUpperCase());
        System.out.println(Integer.toBinaryString(input));
    }
}

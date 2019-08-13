import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class DifferentIntegersSize {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = Long.parseLong(console.nextLine());

        if (n>9223372036854775807l){
            System.out.println(n + " can't fit in any type");
            return;
        }

        System.out.println(n + " can fit in:");
        if (n> -128 && n<=127){
            System.out.println("* byte");
        }

        if (n> -32768 && n<=32767){
            System.out.println("* short");
        }

        if (n> -2147483648 && n<= 2147483647){
            System.out.println("* int");
        }

        if (n> -9223372036854775808l && n<= 9223372036854775807l){
            System.out.println("* long");
        }

    }
}

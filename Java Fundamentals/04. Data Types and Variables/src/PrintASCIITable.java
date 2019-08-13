import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class PrintASCIITable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int start = Integer.parseInt(console.nextLine());
        int end = Integer.parseInt(console.nextLine());

        for (int i=start; i<=end; i++){
            System.out.print((char)i + " ");
        }
    }
}

import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class MaxMethod {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n1 = Integer.parseInt(console.nextLine());
        int n2 = Integer.parseInt(console.nextLine());
        int n3 = Integer.parseInt(console.nextLine());

        int biggerValue = GetMax(n1,n2);
        int biggestValue = GetMax(biggerValue,n3);

        System.out.println(biggestValue);
    }

    public static int GetMax (int a, int b){
        if (a>b){
            return a;
        } else {
            return b;
        }
    }
}

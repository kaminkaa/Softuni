import java.util.Scanner;

/**
 * Created by Cammi on 24/09/2017.
 */
public class IntervalOfNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n1 = Integer.parseInt(console.nextLine());
        int n2 = Integer.parseInt(console.nextLine());

        if(n1<n2){
            for (int i=n1; i<=n2; i++){
                System.out.println(i);
            }
        } else {
            for (int i=n2; i<=n1; i++){
                System.out.println(i);
            }
        }
    }
}

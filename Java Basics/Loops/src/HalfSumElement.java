import java.util.Scanner;

/**
 * Created by Cammi on 20/07/2017.
 */
public class HalfSumElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        int sum = 0;
        int max = 0;
        int number;

        for(int i=0; i<n; i++){
            number = Integer.parseInt(console.nextLine());
            sum += number;
            if(number>max){
                max = number;
            }
        }

        int halfsum = sum - max;
        if(halfsum == max){
            System.out.println("Yes");
            System.out.println("Sum = "+halfsum);
        } else {
            System.out.println("No");
            System.out.println("Diff = "+Math.abs(max-halfsum));
        }
    }
}

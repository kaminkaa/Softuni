import java.util.Scanner;

/**
 * Created by Cammi on 22/07/2017.
 */
public class StopNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        int m = Integer.parseInt(console.nextLine());
        int s = Integer.parseInt(console.nextLine());

        int i;

            for (i=m; i>=n; i--){
                if(i%2==0 && i%3==0){
                    if(i==s){
                        break;
                    } else {
                        System.out.printf("%d ",i);
                    }
                }
            }
    }
}

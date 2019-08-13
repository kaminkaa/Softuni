import java.util.Scanner;

/**
 * Created by Cammi on 03/10/2017.
 */
public class FibonacciNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        if (n==0){
            System.out.println("1");
        } else {
            System.out.println(Fib(n));
        }
    }

    static int Fib (int n){
        if(n <= 2){
            return n;
        }else{
            return Fib(n-1) + Fib(n-2);
        }
    }
}

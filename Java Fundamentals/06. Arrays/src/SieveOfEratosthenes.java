import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());
        int upperBoundSquareRoot = (int) Math.sqrt(number);
        boolean[] primes = new boolean[number + 1];

        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int m = 2; m <= upperBoundSquareRoot; m++) {
            if (primes[m]) {
                for (int k = m * m; k <= number; k += m)
                    primes[k] = false;
                }
        }

        for (int m = 2; m < primes.length; m++) {
            if (primes[m])
                System.out.print(m + " ");
        }
    }
}

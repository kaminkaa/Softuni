import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EqualSums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sumToTheLeft = 0;
        int sumToTheRight = 0;

        if (numbers.length == 1){
            System.out.println(0);
            return;
        }

        boolean isFound = false;
        int indexNumberFound = 0;

        for (int i = 0; i < numbers.length; i++) {
            sumToTheLeft = 0;
            sumToTheRight = 0;

            // sum to the left:
            for (int j = 0; j < i; j++) {
                sumToTheLeft += numbers[j];
            }

            // sum to the right:
            for (int j = numbers.length-1; j > i; j--) {
                sumToTheRight += numbers[j];
            }

            // compare sums:
            if (sumToTheLeft == sumToTheRight){
                indexNumberFound = i;
                isFound = true;
            }
        }

        if (isFound){
            System.out.println(indexNumberFound);
        } else {
            System.out.printf("no");
        }
    }
}

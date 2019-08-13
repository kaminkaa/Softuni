import java.util.Arrays;
import java.util.Scanner;

public class RotateAndSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputNumbers = console.nextLine().split(" ");
        int rotations = Integer.parseInt(console.nextLine());

        int[] numbers = new int[inputNumbers.length];

        for (int i=0; i<inputNumbers.length; i++){
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        int[] sum = new int[numbers.length];
        int reminder;

        for (int j=0; j < rotations; j++){
            reminder = numbers[numbers.length -1];
            for (int i = numbers.length-1; i > 0; i--){
                numbers[i] = numbers[i-1];
                sum[i] += numbers[i];
            }
            numbers[0] = reminder;
            sum[0] += numbers[0];
        }

        for (int i=0; i<sum.length; i++){
            System.out.print(sum[i] + " ");
        }
    }
}

import java.util.Scanner;

public class MaxSequenceIncreasingElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputNumbers = console.nextLine().split(" ");
        int[] numbers = new int[inputNumbers.length];

        for (int i=0; i<inputNumbers.length; i++){
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        int longestSequence = 0;
        int sequenceValue;

        int reminder = numbers[0];
        sequenceValue = numbers[0];
        int sequence = 1;

        for (int i=1; i <= numbers.length-1; i++){
            if ((numbers[i] - reminder) == 1){
                sequence++;
                if (sequence > longestSequence) {
                    longestSequence = sequence;
                    sequenceValue = numbers[i-longestSequence+1];
                }
            } else {
                sequence = 1;
            }
            reminder = numbers[i];
        }

        for (int i=sequenceValue; i < sequenceValue + longestSequence; i++){
            System.out.printf("%d ", i);
        }

        if (longestSequence == 0){
            System.out.println(numbers[0]);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        char letterBefore;
        char letterAfter;
        int number;

        double totalSum = 0;

        for (int i = 0; i < input.length; i++) {
            letterBefore = input[i].charAt(0);
            letterAfter = input[i].charAt(input[i].length() - 1);
            number = Integer.parseInt(input[i].substring(1,input[i].length() - 1));

            totalSum +=  checkLetterAfter(letterAfter,checkLetterBefore(letterBefore,number));
        }

        System.out.printf("%.2f", totalSum);
    }

    static double checkLetterBefore (char letter, int num) {
        double result = -1;

        int asciiValue = letter;

        if (asciiValue >= 65 && asciiValue <= 90){
            result = (double)num / (asciiValue - 64);
        }

        if (asciiValue >= 97 && asciiValue <= 122){
            result = (double)num * (asciiValue - 96);
        }

        return  result;
    }

    static double checkLetterAfter (char letter, double resultedNum) {
        double result = -1;

        int asciiValue = letter;

        if (asciiValue >= 65 && asciiValue <= 90){
            result = resultedNum - (asciiValue - 64);
        }

        if (asciiValue >= 97 && asciiValue <= 122){
            result = resultedNum + (asciiValue - 96);
        }

        return  result;
    }
}

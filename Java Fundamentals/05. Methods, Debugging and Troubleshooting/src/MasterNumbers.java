import java.util.Scanner;

public class MasterNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        for (int i = 1; i <=n; i++){
            if (IsPalindrome(i)){
                if (SumOfDigits(i)){
                    if ((ContainsEvenDigit(i))){
                        System.out.println(i);
                    }
                }
            }
        }
    }

    static boolean ContainsEvenDigit (int num){
        int digit;
        while (num>0){
            digit = num%10;
            if (digit%2 == 0){
                return true;
            } else {
                num /= 10;
            }
        }
        return false;
    }

    static boolean SumOfDigits (int num){
        int sum = 0;

        while (num>0){
            sum += num%10;
            num /= 10;
        }

        if (sum%7 == 0){
            return true;
        } else {
            return false;
        }
    }

    static boolean IsPalindrome (int num){
        String numberString = String.valueOf(num);
        String reverseNumber = "";

        int j = 0;

        for (int i = numberString.length()-1; i>=0; i--){
            reverseNumber = reverseNumber + numberString.charAt(i);
            j++;
        }

        if (reverseNumber.equals(numberString)) {
            return true;
        } else {
            return false;
        }
    }
}

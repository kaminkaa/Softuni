import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String inputLine1 = console.nextLine();
        String inputLine2 = console.nextLine();

        char[] charsLine1 = inputLine1.toCharArray();
        char[] charsLine2 = inputLine2.toCharArray();

        int length = Math.min(charsLine1.length, charsLine2.length);

        boolean isLine1 = false;
        boolean isEqual = false;

        for (int i = 0; i < length; i+=2) {
            if (charsLine1[i] == charsLine2[i]){
                isEqual = true;
                continue;
            }

            if (charsLine1[i] < charsLine2[i]){
                isEqual = false;
                isLine1 = true;
                break;
            } else if (charsLine2[i] < charsLine1[i]){
                isEqual = false;
                break;
            }
        }

        if (isEqual){
            if (charsLine1.length < charsLine2.length){
                PrintCharArray(charsLine1);
                System.out.println();
                PrintCharArray(charsLine2);
            } else {
                PrintCharArray(charsLine2);
                System.out.println();
                PrintCharArray(charsLine1);
            }
        } else {
            if (isLine1) {
                PrintCharArray(charsLine1);
                System.out.println();
                PrintCharArray(charsLine2);
            } else {
                PrintCharArray(charsLine2);
                System.out.println();
                PrintCharArray(charsLine1);
            }
        }
    }

    static void PrintCharArray (char[] arr){
        for (int i = 0; i < arr.length; i+=2) {
            System.out.printf("%c",arr[i]);
        }
    }
}

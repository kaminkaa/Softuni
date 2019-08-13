import java.util.Scanner;

public class LargestCommonEnd {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String line1 = console.nextLine();
        String line2 = console.nextLine();

        String [] itemsList1 = line1.split(" ");
        String [] itemsList2 = line2.split(" ");

        int leftCount = FindMaxCommonItems(itemsList1,itemsList2);

        // reverse itemsList1:
        for(int i = 0; i < itemsList1.length / 2; i++)
        {
            String temp = itemsList1[i];
            itemsList1[i] = itemsList1[itemsList1.length - i - 1];
            itemsList1[itemsList1.length - i - 1] = temp;
        }

        // reverse itemsList2:
        for(int i = 0; i < itemsList2.length / 2; i++)
        {
            String temp = itemsList2[i];
            itemsList2[i] = itemsList2[itemsList2.length - i - 1];
            itemsList2[itemsList2.length - i - 1] = temp;
        }

        int rightCount = FindMaxCommonItems(itemsList1,itemsList2);

        System.out.println(Math.max(leftCount,rightCount));
    }

    static int FindMaxCommonItems (String[] line1, String[] line2){
        int length = Math.min(line1.length, line2.length);
        int count = 0;

        for (int i=0; i < length; i++){
            if (line1[i].equals(line2[i])){
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

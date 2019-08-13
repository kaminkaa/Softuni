import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BePositive {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int countSequences = Integer.parseInt(console.nextLine());

        for (int i = 0; i < countSequences; i++)
        {
            String input = console.nextLine();
           // String[] inputs = input.split("\\s+");

            List<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < input.length(); j++)
            {
                if (input.charAt(j)!= ' ')
                {
                    int num = input.charAt(j);
                    numbers.add(num);
                }
            }

            boolean found = false;

            for (int j = 0; j < numbers.size(); j++)
            {
                int currentNum = numbers.get(j);

                if (currentNum > 0)
                {
                    if (found)
                    {
                        System.out.printf(" ");
                    }

                    System.out.print(currentNum);
                    found = true;
                }
                else
                {
                    currentNum += numbers.get(j+1);

                    if (currentNum > 0)
                    {
                        if (found)
                        {
                            System.out.printf(" ");
                        }

                        System.out.print(currentNum);
                        found = true;
                    }
                }
            }

            if (!found)
            {
                System.out.printf("(empty)");            }
        }
    }
}

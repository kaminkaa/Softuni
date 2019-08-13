import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String text = console.nextLine();
        int jump = Integer.parseInt(console.nextLine());

		String Search = "p";
        boolean hasMatch = false;
        int endIndex;

        for (int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) == Search.charAt(0))
            {
                hasMatch = true;

                if (i==0){
                    endIndex = jump + 1;
                } else {
                    endIndex = jump + i + 1;
                }

                if (endIndex > text.length())
                {
                    endIndex = text.length();
                }

                String matchedString = text.substring(i,endIndex);
                System.out.println(matchedString);
                i += jump;
            }
        }

        if (!hasMatch)
        {
            System.out.printf("no");
        }
    }
}

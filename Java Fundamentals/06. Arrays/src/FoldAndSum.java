import com.sun.deploy.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FoldAndSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int k = numbers.length / 4;
        int[] leftArray = Arrays.stream(numbers).limit(k).toArray();
        int[] middleArray = Arrays.stream(numbers).skip(k).limit(2*k).toArray();
        int[] rightArray = Arrays.stream(numbers).skip(3*k).limit(k).toArray();

        // reverse leftArray:
        for(int i = 0; i < leftArray.length / 2; i++)
        {
            int temp = leftArray[i];
            leftArray[i] = leftArray[leftArray.length - i - 1];
            leftArray[leftArray.length - i - 1] = temp;
        }

        // reverse rightArray:
        for(int i = 0; i < rightArray.length / 2; i++)
        {
            int temp = rightArray[i];
            rightArray[i] = rightArray[rightArray.length - i - 1];
            rightArray[rightArray.length - i - 1] = temp;
        }

        int[] leftRightReversedJoined = new int[2*k];
        System.arraycopy(leftArray,0,leftRightReversedJoined,0,k);
        System.arraycopy(rightArray,0,leftRightReversedJoined,k,k);

        int[] sum = new int[2*k];

        for (int i = 0; i < 2*k; i++) {
            sum[i] = leftRightReversedJoined[i] + middleArray[i];
        }

        for (int i = 0; i < sum.length; i++) {
            System.out.print(sum[i] + " ");
        }
    }
}

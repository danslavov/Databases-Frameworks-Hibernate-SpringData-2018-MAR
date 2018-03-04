package T02_Basics;

import java.util.Arrays;
import java.util.Scanner;

public class P08_MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxIndex = 0;
        int maxLength = 1;
        int curIndex = 0;
        int curLength = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];
            if (current < next) {
                curLength++;
                if (curLength > maxLength) {
                    maxLength = curLength;
                    maxIndex = curIndex;
                }
            } else {
                curIndex = i + 1;
                curLength = 1;
            }
        }

        for (int i = maxIndex; i < maxIndex + maxLength; i++) {
            System.out.print(nums[i]);
            if (i < maxIndex + maxLength - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

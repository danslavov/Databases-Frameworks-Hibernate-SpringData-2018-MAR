package T02_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11_EqualSums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (nums.length < 2) {
            System.out.println("0");
        } else if (nums.length < 3) {
            System.out.println("no");
        } else {
            int leftSum;
            int rightSum;
            for (int i = 0; i < nums.length; i++) {
                leftSum = calculateSum(nums, 0, i - 1);
                rightSum = calculateSum(nums, i + 1, nums.length - 1);
                if (leftSum == rightSum) {
                    System.out.println(i);
                    return;
                }
            }
            System.out.println("no");
        }
    }

    private static int calculateSum(int[] nums, int start, int end) {
        int sum = 0;
        if (start < 0 || end > nums.length - 1) {
            return sum;
        }
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

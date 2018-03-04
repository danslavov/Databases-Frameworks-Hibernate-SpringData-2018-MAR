package T02_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P09_MostFrequentNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int popular = nums[0];
        int frequency = 1;
        int tempFrequency = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            int left = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int right = nums[j];
                if (left == right) {
                    tempFrequency++;
                }
            }

            if (tempFrequency > frequency) {
                popular = left;
                frequency = tempFrequency;
            }

            tempFrequency = 1;
        }
        System.out.println(popular);
    }
}

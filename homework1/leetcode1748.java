package homework1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Sum of Unique Elements
 * time complexity: O(n)
 * space complexity: 0(n)
 */
public class leetcode1748 {
    public static void main(String[] args) {

        leetcode1748 solution = new leetcode1748();

        int[] nums1 = {1, 2, 3, 2};
        System.out.println(solution.sumOfUnique(nums1)); // Expected: 4

        int[] nums2 = {1, 1, 1, 1, 1};
        System.out.println(solution.sumOfUnique(nums2)); // Expected: 0

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(solution.sumOfUnique(nums3)); // Expected: 15

    }
    public int sumOfUnique(int[] nums) {

        Map<Integer, Long> freq = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(
                        num -> num,
                        Collectors.counting()
                ));

        return freq.entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .mapToInt(Map.Entry::getKey)
                .sum();

    }
}

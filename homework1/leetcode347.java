package homework1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Top K Frequent Elements
 * time complexity: O(n)
 * space complexity: 0(n)
 */

public class leetcode347 {
    public static void main(String[] args) {

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = new leetcode347().topKFrequent(nums1, k1);
        System.out.println(Arrays.toString(result1)); // Expected: [1, 2]

        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = new leetcode347().topKFrequent(nums2, k2);
        System.out.println(Arrays.toString(result2)); // Expected: [1]

    }    
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(
                        num -> num,
                        num -> 1,
                        Integer::sum
                ));

        Map<Integer, List<Integer>> buckets = freq.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,                // Group by value
                        Collectors.mapping(
                                Map.Entry::getKey,  // Extract key
                                Collectors.toList() // Collect keys to the list
                        )
                ));

        int maxKey = buckets.keySet().stream()
                .reduce(Integer::max)
                .orElse(Integer.MIN_VALUE);

        int[] ans = IntStream.iterate(maxKey, i -> i > 0, i -> i - 1)
                .filter(buckets::containsKey) // Only retain existing keys
                //If a key corresponds to multiple values, the key value pairs can be flattened using flatMap
                .flatMap(i -> buckets.get(i).stream().mapToInt(Integer::intValue))
                .limit(k) // Limit the length of the result to k
                .toArray();

        return ans;


    }
}

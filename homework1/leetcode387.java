package homework1;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * First Unique Character in a String
 * time complexity: O(n)
 * space complexity: 0(n)
 */
public class leetcode387 {
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        leetcode387 solution = new leetcode387();
        System.out.println(solution.firstUniqChar(s1)); // Expected: 0
        System.out.println(solution.firstUniqChar(s2)); // Expected: 2
        System.out.println(solution.firstUniqChar(s3)); // Expected: -1
    }

    public int firstUniqChar(String s) {

        Map<Character, Long> frquencyMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        int result = IntStream.range(0, s.length())
                .filter(i -> frquencyMap.get(s.charAt(i)) == 1)
                .findFirst()
                .orElse(-1);

        return result;
    }
}

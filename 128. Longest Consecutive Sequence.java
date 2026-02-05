import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> subgraphs = new HashMap<>();
        int result = 0;

        for (int num : nums) {
            if (subgraphs.containsKey(num)) {
                continue;
            }

            int leftBoundaryGraphLength = subgraphs.getOrDefault(num - 1, 0);
            int rightBoundaryGraphLength = subgraphs.getOrDefault(num + 1, 0);
            int newGraphLength = leftBoundaryGraphLength + rightBoundaryGraphLength + 1;

            subgraphs.put(num, newGraphLength);
            subgraphs.put(num - leftBoundaryGraphLength, newGraphLength);
            subgraphs.put(num + rightBoundaryGraphLength, newGraphLength);

            result = Math.max(result, newGraphLength);
        }

        return result;
    }
}
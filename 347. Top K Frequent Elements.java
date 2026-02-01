import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.merge(num, 1, Integer::sum);
        }

        List<List<Integer>> buckets = new ArrayList<>(nums.length + 1);

        for (int i = 0; i <= nums.length; i++) {
            buckets.add(null); 
        }

        counts.forEach((num, freq) -> {
            if (buckets.get(freq) == null) {
                buckets.set(freq, new ArrayList<>());
            }
            buckets.get(freq).add(num);
        });

        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.size() - 1; i >= 0 && index < k; i--) {
            if (buckets.get(i) != null) {
                for (int num : buckets.get(i)) {
                    result[index++] = num;
                    if (index == k) return result;
                }
            }
        }

        return result;
    }
}
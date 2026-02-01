import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        List<List<Integer>> frequencies = IntStream.range(0, nums.length)
            .mapToObj(_ -> new ArrayList<Integer>())
            .collect(Collectors.toList());

        for (int num : nums) {
            counts.merge(num, 1, Integer::sum);
        }

        counts.forEach((key, value) -> {
            frequencies.get(value - 1).add(key);
        });

        int[] result = new int[k];
        int count = 0;

        while (count != k) {
            for (int i = nums.length - 1; i > -1; i--) {
                List<Integer> list = frequencies.get(i);
                if (list.size() > 0) {
                    for (Integer num : list) {
                        result[count] = num;
                        count++;
                        if (count >= k) {
                            return result;
                        }
                    }
                }
            }
        }

        return new int[] {-1};
    }
}
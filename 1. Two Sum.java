import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) {
            if (seen.containsKey(target - num)) {
                return new int[] {seen.get(target - num), i};
            } else {
                seen.put(num, i);
            }
            i++;
        }
        return new int[] {0, 0};
    }
}
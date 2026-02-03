class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] forwards = new int[nums.length];
        int[] backwards = new int[nums.length];

        forwards[0] = nums[0];
        backwards[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            forwards[i] = forwards[i - 1] * nums[i];
        }

        for (int i = nums.length - 2; i > -1; i--) {
            backwards[i] = backwards[i + 1] * nums[i];
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            boolean leftAccessable = i - 1 >= 0;
            boolean rightAccessable = i + 1 < nums.length;
            if (leftAccessable && rightAccessable) {
                result[i] = forwards[i - 1] * backwards[i + 1];
            } else if (leftAccessable) {
                result[i] = forwards[i - 1];
            } else {
                result[i] = backwards[i + 1];
            }
        }

        return result;
    }
}
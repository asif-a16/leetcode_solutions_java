class Solution {
    public int trap(int[] height) {
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int result = 0;

        int left = 0;
        int right = height.length - 1;

        while (left <= right) {
            int minBoundary = Math.min(leftMax, rightMax);
            if (leftMax < rightMax) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                    left++;
                } else {
                    result += minBoundary - height[left];
                    left++;
                }
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                    right--;
                } else {
                    result += minBoundary - height[right];
                    right--;
                }
            }
        }

        return result;
    }
}
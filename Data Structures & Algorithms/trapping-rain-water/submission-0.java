class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        int []leftMax = new int[n];
        int []rightMax = new int[n];
        int max = -1;
        
        for(int i = 0 ; i < n ; i++ ) {
            leftMax[i] = max;
            max = Math.max(max, height[i]);
        }   
        max = -1;
        for(int i = n - 1; i >= 0 ; i--) {
            rightMax[i] = max;
            max = Math.max(height[i] , max);
        }

        for(int i = 0; i < n ; i++) {
            if(height[i] < leftMax[i] && height[i] < rightMax[i])
                ans += Math.min(leftMax[i] , rightMax[i]) - height[i];
        }

        return ans;
    }
}

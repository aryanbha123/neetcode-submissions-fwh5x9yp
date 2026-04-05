class Solution {
    public int maxArea(int[] heights) {
        // 7 , 6 = 6 * (7 - 1) = 36
        int n = heights.length;
        int ans = 0;
        for(int i = 0; i < n -1; i++) {
            for(int j = i + 1; j < n ;j++) {
                int temp = (j-i) * Math.min(heights[i],heights[j]);
                ans = Math.max(ans,temp);
            }
        }

        return ans;
    }
}

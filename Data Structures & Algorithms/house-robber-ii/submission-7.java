class Solution {
    public int helper(int []nums, int index,int N, int []dp) {
        if(index >= N) return 0;
        if(dp[index] != -1) return dp[index];
        int take = nums[index] + helper(nums,index+2,N,dp); 
        int notTake = helper(nums,index+1,N,dp); 
        return dp[index] = Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        
        int N = nums.length;
        if(N == 1) return nums[N-1];
        int []dp1 = new int[N];
        int []dp2 = new int[N];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(helper(nums, 0, N-1, dp1), helper(nums,1,N,dp2));
    }
}

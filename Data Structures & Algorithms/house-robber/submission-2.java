class Solution {

    public int helper(int []profit, int i, int []dp) { 
        if(i >= profit.length) { 
            return 0;
        }
        if(dp[i] != -1) return dp[i];

        int rob = profit[i] + helper(profit, i +2 , dp);
        int leave = helper(profit, i +1,dp);

        return dp[i] = Math.max(rob,leave);
    }
    public int rob(int[] nums) {
        int N = nums.length;
        int []dp = new int[N];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
}

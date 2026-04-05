class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // int []postfix = new int[n]; // O(N)
        int []ans = new int[n];  // O(N)
        ans[0] = 1;
        for(int i = 1 ; i < n ; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        
        // postfix[n-1] = 1;
        // for(int i = n - 2 ; i>=0 ; i--) {
        //     postfix[i] = nums[i+1] * postfix[i+1];
        // }


        int right = 1;
        for(int i = n -1 ; i >= 0 ;i--) {
            ans[i] *=  right;
            right *= nums[i];
        }

        return ans;

    }
}  

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int n = nums.length;
        // int []temp = new int[n];
        // for(int i = 0;i < n ; i++) {
        //     int prod = 1;
        //     for(int j = 0 ; j < n ; j++) {
        //         if(i != j) {
        //             prod *= nums[j];
        //         }
        //     }
        //     temp[i] = prod;
        // }
        // return temp;


        // int n = nums.length;
        // int []temp = new int[n];
        // int []left = new int[n];
        // int []right = new int[n];

        // left[0] = 1;
        // right[n-1] = 1;
        // for(int i = 1; i < n; i++) {
        //     left[i] = nums[i-1] * left[i-1];
        // }

        // for(int i = n-2; i >= 0; i--) {
        //     right[i] = nums[i+1] * right[i+1];
        // }

            int n = nums.length;
            int []ans = new int[n];
            for(int i = 0 ; i < n ; i++) {
                int product = 1;
                for(int j = 0 ; j < n ; j++ ) {
                    if(i != j) {
                        product *= nums[j];
                    }
                }
                ans[i] = product;

            }

            return ans;

        
    }
}  

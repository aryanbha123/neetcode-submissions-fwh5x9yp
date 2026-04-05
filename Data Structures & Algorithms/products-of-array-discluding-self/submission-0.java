class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int []temp = new int[n];
        for(int i = 0;i < n ; i++) {
            int prod = 1;
            for(int j = 0 ; j < n ; j++) {
                if(i != j) {
                    prod *= nums[j];
                }
            }
            temp[i] = prod;
        }
        return temp;
    }
}  

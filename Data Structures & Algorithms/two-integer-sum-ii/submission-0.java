class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 2 Pointer 
        // l r 
        // 1 pointer 
        int l = 0, r = numbers.length - 1;

        while(l < r) {
            int num1 = numbers[l];
            int num2 = numbers[r];
            int ans = num1 + num2;
            
            if(ans == target) return new int[]{l+1,r+1};
            else if(ans > target) r--;
            else l++;
        }

        return new int[]{-1,-1};
    }
}

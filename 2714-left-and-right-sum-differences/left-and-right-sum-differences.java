class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int total = 0;
        for(int i = 0; i < n; i++) {
            total += nums[i];    
        }
        for(int i=0;i<n;i++){
            total = total - nums[i];
            ans[i] = ans[i] = Math.abs(left - total);
            left = left + nums[i];
        }
        return ans;
    }
        
}

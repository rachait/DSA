class Solution {
    public int missingNumber(int[] nums) {
        int range = nums.length;

        for (int i = 0; i < nums.length; i++) {
            range += i - nums[i];
        }
        
        return range;       
    }
}
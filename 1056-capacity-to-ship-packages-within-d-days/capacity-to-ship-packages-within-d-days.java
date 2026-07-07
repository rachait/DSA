class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high  = 0;
        for(int w : weights){
            low = Math.max(low,w);
            high+=w;
        }
        while(low<=high){
            int mid = (low+high)/2;
            int req = 1;
            int cur = 0;
            for(int w : weights){
                if(cur+w > mid){
                    req++;
                    cur =0;
                }
                cur+=w;
            }
            if(req<=days){
                high = mid- 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}
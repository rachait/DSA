class Solution {
    public int maxTwoEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int ans=events[0][2];
        for(int x[]:events) ans=Math.max(ans,x[2]);
        int dp[]=new int[n];
        dp[n-1]=events[n-1][2];
        for(int i=n-2;i>=0;i--){
            dp[i]=Math.max(dp[i+1], events[i][2]);
        }
        for(int i=0;i<n;i++){
            int end=events[i][1];
            int l=i+1,r=n-1, pos=-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(events[mid][0]>end){
                    pos=mid;
                    r=mid-1;
                }
                else l=mid+1;
            }
            if(pos!=-1) ans=Math.max(ans,events[i][2]+dp[pos]);
        }
        return ans;
    }
}

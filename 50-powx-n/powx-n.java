class Solution {
    public double myPow(double x, int n) {
        return binaryEp(x,(long) n);
    }
    private double binaryEp(double x, long n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 1.0 / binaryEp(x, -n);
        }
        if(n%2==1){
            return x * binaryEp(x * x, (n-1)/2);
        }
        else{
            return binaryEp(x*x,n/2);
        }
    }
}
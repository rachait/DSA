class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for(int i = num1; i<=num2;i++){
            total += getWaviness(i);
        }
        return total;
    }
    private int getWaviness(int num){
        String s = Integer.toString(num);
        int waviness = 0;
        for(int i=1; i < s.length() - 1;i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            char next = s.charAt(i+1);
            if(curr > prev && curr>next){
                waviness++;
            }
            else if(curr < prev && curr < next){
                waviness++;
            }
        }
        return waviness;
    }
}
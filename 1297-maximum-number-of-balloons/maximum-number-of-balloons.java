class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        int fre[] = new int [26];
        for(int i=0;i<n;i++){
            char ch = text.charAt(i);
            fre[ch-'a']++;
        }
        int min = fre['b'-'a'];
        min = Math.min(min, fre[0]);
        min = Math.min(min, fre['n' - 'a']);
        min = Math.min(min, fre['l' - 'a']/2);
        min = Math.min(min, fre['o' - 'a']/2);

        return min;
    }
}
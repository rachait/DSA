class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        long[] up = new long[m], down = new long[m];

        for (int i = 0; i < m; i++) {
            up[i] = i;
            down[i] = m - 1 - i;
        }

        for (int len = 3; len <= n; len++) {
            long[] nu = new long[m], nd = new long[m];

            long pre = 0;
            for (int i = 0; i < m; i++) {
                nu[i] = pre;
                pre = (pre + down[i]) % MOD;
            }

            long suf = 0;
            for (int i = m - 1; i >= 0; i--) {
                nd[i] = suf;
                suf = (suf + up[i]) % MOD;
            }

            up = nu;
            down = nd;
        }

        long ans = 0;
        for (int i = 0; i < m; i++)
            ans = (ans + up[i] + down[i]) % MOD;

        return (int) ans;
    }
}
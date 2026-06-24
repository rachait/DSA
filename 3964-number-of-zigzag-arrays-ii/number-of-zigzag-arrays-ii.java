class Solution {
    static final long MOD = 1_000_000_007L;

    long[][] mul(long[][] a, long[][] b) {
        int n = a.length;
        long[][] c = new long[n][n];

        for (int i = 0; i < n; i++)
            for (int k = 0; k < n; k++)
                if (a[i][k] != 0)
                    for (int j = 0; j < n; j++)
                        if (b[k][j] != 0)
                            c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;

        return c;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1, sz = 2 * m;
        long[][] t = new long[sz][sz], res = new long[sz][sz];

        for (int i = 0; i < sz; i++) res[i][i] = 1;

        for (int x = 0; x < m; x++) {
            for (int y = x + 1; y < m; y++) t[x][m + y] = 1;
            for (int y = 0; y < x; y++) t[m + x][y] = 1;
        }

        for (long p = n - 1; p > 0; p >>= 1) {
            if ((p & 1) == 1) res = mul(res, t);
            t = mul(t, t);
        }

        long ans = 0;
        for (long[] row : res)
            for (long v : row)
                ans = (ans + v) % MOD;

        return (int) ans;
    }
}
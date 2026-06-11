import java.util.*;
class Solution {
        static final long MOD = 1_000_000_007L;
        List<Integer>[] graph;
        int maxDepth =0;
        public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        dfs(1, 0, 0);

        return (int) modPow(2, maxDepth - 1);
    }
     private void dfs(int node, int parent, int depth) {
        maxDepth = Math.max(maxDepth, depth);

        for (int next : graph[node]) {
            if (next != parent) {
                dfs(next, node, depth + 1);
            }
        }
    }
    private long modPow(long base, long exp) {
        long ans = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }
return ans;
    }
    }

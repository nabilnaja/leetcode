package graph.leetcode1101;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int earliestAcq(int[][] logs, int n) {

        if (logs.length < n - 1)
            return -1;

        Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));


        UnionFind uf = new UnionFind(n);

        for(int[] log : logs){
            if(uf.union(log[1], log[2]))
                return log[0];
        }
        return -1;
    }

    static class UnionFind{
        private final int[] rank;
        private final int[] root;
        private int n;
        public UnionFind(int n){
            rank = new int[n];
            root = new int[n];
            this.n = n;
            for(int i=0 ; i < n; i++){
                rank[i] = 1;
                root[i] = i;
            }
        }

        private int find(int x){
            if(x == root[x])
                return x;
            return root[x] = find(root[x]);
        }

        public boolean union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);

            if (rootx != rooty){
                if(rank[rootx] < rank[rooty]){
                    root[rootx] = rooty;
                }
                else if(rank[rootx] > rank[rooty]){
                    root[rooty] = rootx;
                }
                else{
                    root[rootx] = rooty;
                    rank[rooty]++;
                }
                return --n == 1;
            }
            return false;
        }
    }
}



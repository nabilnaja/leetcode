package graph.leetcode1584;

import java.util.*;

class Solution {
    public int minCostConnectPointsHeap(int[][] points) {
        PriorityQueue<int[]> heap = new PriorityQueue<>( Comparator.comparing((int[] o1)-> o1[2]));

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                heap.add(new int[]{i, j, distance});
            }
        }
        int n = points.length;

        UnionFind uf = new UnionFind(n);
        int minCost = 0;
        while (n > 1){
            int[] edge = heap.poll();
            if(uf.union(edge[0], edge[1])){
                minCost += edge[2];
                n--;
            }

        }
        return minCost;
    }

    static class UnionFind{
        int[] rank;
        int[] root;

        public UnionFind(int n){
            rank = new int[n];
            root = new int[n];

            for(int i = 0; i < n;i++){
                rank[i] = 1;
                root[i] = i;
            }
        }

        public int find(int x){
            if(root[x] == x)
                return x;
            return root[x] = find(root[x]);
        }

        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if( rootX == rootY)
                return false;
            else {
                if (rank[rootX] < rank[rootY]){
                    root[rootX] = rootY;
                }
                else if (rank[rootX] > rank[rootY]){
                    root[rootY] = rootX;
                }
                else {
                    root[rootY] = rootX;
                    rank[rootX] ++;
                }
                return true;
            }
        }
    }
}
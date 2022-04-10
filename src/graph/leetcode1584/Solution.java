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

    public int minCostConnectPointsQuickSort(int[][] points) {
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, distance});
            }
        }
        edges.sort(Comparator.comparing(o -> o[2]));
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        int minCost = 0;
        int edgesUsed = 0;

        for (int i = 0; i < edges.size() && edgesUsed < n - 1; ++i) {
            if (uf.union(edges.get(i)[0], edges.get(i)[1])) {
                minCost += edges.get(i)[2];
                edgesUsed++;
            }
        }
        return minCost;
    }

    public int minCostConnectPointsPrim(int[][] points) {

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing((o -> o[2])));
        int size = points.length;
        boolean[] visited = new boolean[size];
        int result = 0;
        int count = size - 1;

        int[] start = points[0];
        for (int j = 1; j < size; j++) {
            int distance = Math.abs(start[0] - points[j][0]) + Math.abs(start[1] - points[j][1]);
            heap.add(new int[]{0, j, distance});
        }
        visited[0] = true;

        while (!heap.isEmpty() && count > 0) {
            int[] edge = heap.poll();
            int point1 = edge[0];
            int point2 = edge[1];
            int cost = edge[2];
            if (!visited[point2]) {
                result += cost;
                visited[point2] = true;
                for (int j = 0; j < size; j++) {
                    if (!visited[j]) {
                        int distance = Math.abs(points[point2][0] - points[j][0]) +
                                Math.abs(points[point2][1] - points[j][1]);
                        heap.add(new int[]{point2, j, distance});
                    }
                }
                count--;
            }

        }

        return result;
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
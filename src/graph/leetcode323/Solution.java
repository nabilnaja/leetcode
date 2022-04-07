package graph.leetcode323;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        boolean[] visited = new boolean[n];

        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < edges.length; i++) {
            if(!visited[i]){
                components++;
                dfs(i, adjList, visited);
            }
        }
        return components;
    }
    private void dfs(int vertice, List<Integer>[] adjList, boolean[] visited){
        visited[vertice] = true;
        adjList[vertice].forEach(node -> {
            if(!visited[node]){
                dfs(node, adjList, visited);
            }
        });
    }

    public int countComponentsUnionFind(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.count;
    }
    static class UnionFind {
        private final int[] root;
        private final int[] rank;
        public int count;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }
    }
}



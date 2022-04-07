package graph.leetcode261;

import java.util.*;

class Solution {

    public boolean validTree_1(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        Map<Integer,Integer> parents = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        parents.put(0,-1);

        while (!stack.isEmpty()){
            int node = stack.pop();

            for(int neighbour : adjacencyList.get(node)){
                if (parents.get(node) == neighbour) {
                    continue;
                }
                if(parents.containsKey(neighbour))
                    return false;
                stack.add(neighbour);
                parents.put(neighbour, node);
            }
        }
        return parents.size() == n;
    }
    public boolean validTree_2(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.add(0);
        seen.add(0);

        while (!stack.isEmpty()){
            int node = stack.pop();
            for(int neighbour : adjacencyList.get(node)){
                if(seen.add(neighbour)){
                    stack.add(neighbour);
                }
            }
        }
        return seen.size() == n;
    }

    static class UnionFind {
        private final int[] root;
        private final int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
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

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootY == rootX) {
                return false;
            }
            else {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
            return true;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public boolean validTreeUnionFind(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }
}
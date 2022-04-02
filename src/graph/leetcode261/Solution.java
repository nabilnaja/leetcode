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
}
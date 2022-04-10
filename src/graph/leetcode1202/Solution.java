package graph.leetcode1202;

import java.util.*;

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        UnionFind uf = new UnionFind(s.length());

        pairs.forEach(pair -> uf.union(pair.get(0), pair.get(1)));

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            int root = uf.find(i);
            map.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        char[] smallestString = new char[s.length()];

        map.values().forEach(group -> {
            List<Character> characters = new ArrayList<>();
            group.forEach(index -> characters.add(s.charAt(index)));
            Collections.sort(characters);
            for (int index = 0; index < group.size(); index++) {
                smallestString[group.get(index)] = characters.get(index);
            }
        });
        return new String(smallestString);
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

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY){
                if (rank[rootX] < rank[rootY]){
                    root[rootX] = rootY;
                }
                else if (rank[rootX] > rank[rootY]){
                    root[rootY] = rootX;
                }
                else {
                    root[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                }
            }
        }
    }
}
package graph.leetcode207;

import java.util.*;

public class SolutionTopological {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();

        int[] inDegree = new int[numCourses];
        int total_edge=prerequisites.length;
        int removed=0;

        for (int[] pair : prerequisites) {
            graph.computeIfAbsent(pair[1], key -> new LinkedList<>()).add(pair[0]);
            inDegree[pair[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            LinkedList<Integer> vertices = graph.get(q.poll());
            if (vertices == null)
                continue;

            while (vertices.size() > 0) {
                int adj = vertices.remove();
                inDegree[adj]--;
                removed++;
                if (inDegree[adj] == 0) {
                    q.add(adj);
                }
            }

        }
        return removed==total_edge;
    }

}
package graph.leetcode207;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SolutionDFS {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courseDict = new HashMap<>();

        for (int[] relation : prerequisites) {
            // relation[0] depends on relation[1]
            if (courseDict.containsKey(relation[1])) {
                courseDict.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                courseDict.put(relation[1], nextCourses);
            }
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] processed = new boolean[numCourses];

        for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
            if (this.isCyclic(currCourse, courseDict, visited,processed )) {
                return false;
            }
        }

        return true;
    }

    protected boolean isCyclic( Integer currCourse, Map<Integer, List<Integer>> courseDict, boolean[] visited, boolean[] processed) {

        if (processed[currCourse])
            return false;
        if (visited[currCourse])
            return true;


        if (!courseDict.containsKey(currCourse))
            return false;

        visited[currCourse] = true;

        boolean ret = false;
        for (Integer nextCourse : courseDict.get(currCourse)) {
            ret = this.isCyclic(nextCourse, courseDict, visited,processed);
            if (ret)
                break;
        }
        processed[currCourse] = true;
        visited[currCourse] = false;
        return ret;
    }
}
package graph.leetcode207;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SolutionBT {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // course -> list of next courses
        Map<Integer, List<Integer>> courseDict = new HashMap<>();

        // build the graph first
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

        boolean[] path = new boolean[numCourses];

        for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
            if (this.isCyclic(currCourse, courseDict, path)) {
                return false;
            }
        }

        return true;
    }

    protected boolean isCyclic(Integer currCourse,  Map<Integer, List<Integer>> courseDict, boolean[] path) {

        if (path[currCourse]) {
            return true;
        }

        if (!courseDict.containsKey(currCourse))
            return false;

        path[currCourse] = true;

        boolean ret = false;
        for (Integer nextCourse : courseDict.get(currCourse)) {
            ret = isCyclic(nextCourse, courseDict, path);
            if (ret)
                break;
        }

        path[currCourse] = false;
        return ret;
    }
}



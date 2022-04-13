package graph.leetcode743;

import java.util.*;

class Solution {
    Map<Integer, List<int[]>> adj = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        int[] signals = new int[n + 1];

        Arrays.fill(signals, Integer.MAX_VALUE);

        dijkstra(signals, n, k);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signals[i]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dijkstra(int[] signals, int n, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(n, Comparator.comparing(signal -> signal[1]));
        queue.add(new int[]{k, 0});
        signals[k] = 0;

        while (!queue.isEmpty()) {
            final int[] node = queue.poll();
            if (signals[node[0]] < node[1])
                continue;
            if (!adj.containsKey(node[0]))
                continue;
            adj.get(node[0]).forEach(neighbour -> {
                int cost = neighbour[1] + signals[node[0]];
                if (cost < signals[neighbour[0]]) {
                    queue.add(new int[]{neighbour[0], cost});
                    signals[neighbour[0]] = cost;
                }
            });
        }
    }
}

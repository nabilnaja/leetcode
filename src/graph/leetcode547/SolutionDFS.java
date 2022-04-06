package graph.leetcode547;

class SolutionDFS {

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                count++;
                bfs(isConnected, visited, i);
            }
        }
        return count;
    }
    public void bfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for(int j = 0; j < isConnected.length; j++){
            if( isConnected[i][j] == 1 && !visited[j]){
                bfs(isConnected, visited, j);
            }
        }
    }
}



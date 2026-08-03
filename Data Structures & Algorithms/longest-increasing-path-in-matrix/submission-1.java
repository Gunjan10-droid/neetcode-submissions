class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] indegree = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int ans = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int d=0; d<4; d++){
                    int nx = i+dx[d];
                    int ny = j+dy[d];
                    if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                    if(matrix[nx][ny] < matrix[i][j]) indegree[i][j]++;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(indegree[i][j]==0) q.offer(new int[]{i, j});
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];
                for(int d=0; d<4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                    if(matrix[x][y] < matrix[nx][ny]){
                        indegree[nx][ny]--;
                        if(indegree[nx][ny]==0)q.offer(new int[]{nx, ny});
                    } 
                }
            }
            ans++;
        }
        return ans;
    }
}

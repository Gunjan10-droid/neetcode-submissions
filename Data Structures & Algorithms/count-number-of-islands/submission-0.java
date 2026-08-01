class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.offer(new int[]{i, j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] pos = q.poll();
                        int x = pos[0];
                        int y = pos[1];
                        for(int d=0; d<4; d++){
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                            if(grid[nx][ny]=='1'){
                                grid[nx][ny] = '0';
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

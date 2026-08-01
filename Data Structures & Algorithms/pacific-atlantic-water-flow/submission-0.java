class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights){
        int n = heights.length;
        int m = heights[0].length;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            ocean[x][y] = true;
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx<0 || ny<0 || nx>=n || ny>=m || ocean[nx][ny] || heights[nx][ny] < heights[x][y]) continue;
                q.offer(new int[]{nx, ny});
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];
        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();
        for(int i=0; i<n; i++){
            pacQ.add(new int[]{i, 0});
            atlQ.add(new int[]{i, m-1});
        }
        for(int j=0; j<m; j++){
            pacQ.add(new int[]{0, j});
            atlQ.add(new int[]{n-1, j});
        }
        bfs(pacQ, pac, heights);
        bfs(atlQ, atl, heights);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
}

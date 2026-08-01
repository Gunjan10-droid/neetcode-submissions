class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int i=0; i<n; i++){
           if(board[i][0]=='O'){
                q.offer(new int[]{i, 0});
                board[i][0] = '#';
           } 
           if(board[i][m-1]=='O'){
            q.offer(new int[]{i, m-1});
            board[i][m-1] = '#';
           }
        }
        for(int j=0; j<m; j++){
           if(board[0][j]=='O'){
                q.offer(new int[]{0, j});
                board[0][j] = '#';
           } 
           if(board[n-1][j]=='O'){
            q.offer(new int[]{n-1, j});
            board[n-1][j] = '#';
           }
        }
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(board[nx][ny]=='O'){
                    board[nx][ny]='#';
                    q.offer(new int[]{nx, ny});
                } 
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='#') board[i][j]='O';
            }
        }
    }
}

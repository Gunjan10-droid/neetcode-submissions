class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] dp;
    private int dfs(int[][] matrix, int r, int c, int prevVal){
        int row = matrix.length;
        int col = matrix[0].length;
        if(r<0 || r>=row || c<0 || c>=col || matrix[r][c] <= prevVal) return 0;
        if(dp[r][c] != -1) return dp[r][c];
        int res = 1;
        for(int[] d : directions){
            res = Math.max(res, 1+dfs(matrix, r+d[0], c+d[1], matrix[r][c]));
        }
        return dp[r][c] = res;
    } 
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        dp = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                dp[i][j] = -1;
            }
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                ans = Math.max(ans, dfs(matrix, i, j, Integer.MIN_VALUE));
            }
        }
        return ans;
    }
}

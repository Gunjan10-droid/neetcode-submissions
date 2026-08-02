class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=0; i<m-1; i++){
            int[] temp = new int[n];
            Arrays.fill(temp, 1);
            for(int j=n-2; j>=0; j--){
                temp[j] = dp[j] + temp[j+1];
            }
            dp = temp;
        }
        return dp[0];
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int num : nums) total += num;
        if(Math.abs(target)>total) return 0;
        if((total+target) % 2 != 0) return 0;
        int req = (total+target) / 2;
        int[][] dp = new int[n+1][req+1];
        dp[n][0] = 1;
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=req; j++){
                dp[i][j] = dp[i+1][j];
                if(nums[i] <= j){
                    dp[i][j] += dp[i+1][j-nums[i]];
                }
            }
        }
        return dp[0][req];
    }
}

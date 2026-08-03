class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int num : nums) total += num;
        if(Math.abs(target)>total) return 0;
        if((total+target) % 2 != 0) return 0;
        int req = (total+target) / 2;
        int[] prev = new int[req+1];
        int[] curr = new int[req+1];
        prev[0] = 1;
        curr[0] = 1;
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=req; j++){
                curr[j] = prev[j];
                if(nums[i] <= j){
                    curr[j] = curr[j] + prev[j-nums[i]];
                }
            }
            prev = curr.clone();
        }
        return prev[req];
    }
}

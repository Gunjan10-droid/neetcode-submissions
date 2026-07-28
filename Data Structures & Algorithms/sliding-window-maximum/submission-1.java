class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        leftmax[0] = nums[0];
        rightmax[n-1] = nums[n-1];
        for(int i=1; i<n; i++){
            if(i%k == 0) leftmax[i] = nums[i];
            else{
                leftmax[i] = Math.max(leftmax[i-1], nums[i]);
            }
            if((n-1-i)%k == 0) rightmax[n-1-i] = nums[n-1-i];
            else{
                rightmax[n-1-i] = Math.max(rightmax[n-i], nums[n-1-i]);
            }
        }
        int[] output = new int[n-k+1];
        for(int i=0; i<n-k+1; i++){
            output[i] = Math.max(leftmax[i+k-1], rightmax[i]);
        }
        return output;
    }
}

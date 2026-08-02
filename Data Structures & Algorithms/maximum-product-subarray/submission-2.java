class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];
        for(int i=1; i<n; i++){
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(curr*maxProd, curr*minProd));
            int tempMin = Math.min(curr, Math.min(curr*maxProd, curr*minProd));
            maxProd = tempMax;
            minProd = tempMin;
            res = Math.max(res, maxProd);
        }
        return res;
    }
}

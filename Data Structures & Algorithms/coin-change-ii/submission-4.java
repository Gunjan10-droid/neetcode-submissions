class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
        prev[0] = 1;
        curr[0] = 1;
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=amount; j++){
                if(coins[i] <= j){
                    curr[j] = prev[j];
                    curr[j] = prev[j] + curr[j-coins[i]];
                } 
            }
            prev = curr.clone();
        }
        return prev[amount];
    }
}

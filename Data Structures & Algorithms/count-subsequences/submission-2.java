class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        prev[m] = 1;
        curr[m] = 1;
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                curr[j] = prev[j];
                if(s.charAt(i)==t.charAt(j)){
                    curr[j] = curr[j] + prev[j+1];
                }
            }
            prev = curr.clone();
        }
        return prev[0];
    }
}

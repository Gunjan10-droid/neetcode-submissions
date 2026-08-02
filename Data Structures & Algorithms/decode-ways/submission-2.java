class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0)=='0') return 0;
        int prev2 = 1;
        int prev1 = 1;
        for(int i=2; i<=n; i++){
            int curr = 0;
            int one = s.charAt(i-1) - '0';
            int two = Integer.parseInt(s.substring(i-2, i));
            if(one >= 1 && one <= 9) curr += prev1;
            if(two >= 10 && two <= 26) curr += prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

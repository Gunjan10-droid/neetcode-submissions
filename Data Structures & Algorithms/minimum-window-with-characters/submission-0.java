class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        Map<Character, Integer> cT = new HashMap<>();
        Map<Character, Integer> cS = new HashMap<>();
        for(char c : t.toCharArray()){
            cT.put(c, cT.getOrDefault(c, 0)+1);
        }
        int have = 0;
        int need = cT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);
            cS.put(c, cS.getOrDefault(c, 0)+1);
            if(cT.containsKey(c) && cS.get(c).equals(cT.get(c))) have++;
            while(have == need){
                if((r-l+1) < resLen){
                    resLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                } 
                char leftChar = s.charAt(l);
                cS.put(leftChar, cS.get(leftChar)-1);
                if(cT.containsKey(leftChar) && cS.get(leftChar) < cT.get(leftChar)) have--;
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
    }
}

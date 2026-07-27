class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[n+1];
        int[] res = new int[k];
        for(int i=0; i<freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        int index = 0;
        for(int i=freq.length-1; i>0 && index<k; i--){
            for(int f : freq[i]){
                res[index++] = f;
                if(index == k) return res;
            }
        } 
        return res;
    }
}

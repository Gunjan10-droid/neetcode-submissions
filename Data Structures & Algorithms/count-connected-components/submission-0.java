class Solution {
    private void dfs(int node, List<List<Integer>> adj, boolean[] visit){
        visit[node] = true;
        for(int nei : adj.get(node)){
            if(!visit[nei]) dfs(nei, adj, visit);
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i=0; i<n; i++){
            if(!visit[i]){
                count++;
                dfs(i, adj, visit);
            }
        }
        return count;
    }
}

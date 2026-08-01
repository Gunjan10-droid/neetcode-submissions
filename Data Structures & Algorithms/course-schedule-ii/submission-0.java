class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];
            adj.get(a).add(b);
            indegree[b]++;
        }
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0) q.offer(i);
        }
        int[] order = new int[numCourses];
        int finish = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            order[numCourses-finish-1] = node;
            finish++;
            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0) q.offer(nei);
            }
        }
        if(finish != numCourses) return new int[0];
        return order;
    }
}

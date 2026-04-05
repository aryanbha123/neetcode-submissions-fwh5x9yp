class Solution {
    public boolean validTree(int V, int[][] edges) {
        // detecing a cycle as a tree is nothing but an acycling graph

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<int []> q = new LinkedList<>();
        boolean []visited = new boolean[V];
        visited[0] = true;
        q.add(new int[]{0,-1});
        while(!q.isEmpty()) {
            int []curr = q.poll();

            int node = curr[0];
            int parent = curr[1];

            for(int adjNode : adj.get(node)) {
               if(!visited[adjNode]) {
                    visited[adjNode] = true;
                    q.add(new int[]{adjNode, node});
               }
               else{
                    if(parent != adjNode) {
                        return false;
                    }   
               }

            }
        }
        for(boolean i : visited) {
            if(!i) return false;
        } 
        return true;
    }
}

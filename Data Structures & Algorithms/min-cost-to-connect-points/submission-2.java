class DSU { 

    int []parent;
    int []size;
    DSU(int V) {
        parent = new int[V];
        size = new int[V];
        for(int i = 0 ; i <V ;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    // finding ultimate parent
    int findUparent(int n){
        if(n == parent[n]) return n;
        // path compression
        return parent[n] = findUparent(parent[n]);
    }

    void union(int u , int v) {
        int pu = findUparent(u);
        int pv = findUparent(v);

        if(pu == pv) return;

        if(size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        }else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
} 
class Solution {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<int[]> edges = new ArrayList<>();
        // krushkals algo
        for(int i = 0 ; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                if(i == j) continue;
                int []x = points[i];
                int []y = points[j];
                int wt = Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
                edges.add(new int[]{wt,i,j});
            }
        }
        Collections.sort(edges, (a,b) -> a[0] - b[0]);
        int ans = 0;
        DSU ds = new DSU(points.length);
        for(int []edge: edges){
            int wt = edge[0];
            int u = edge[1];
            int v = edge[2];
            if(ds.findUparent(u) != ds.findUparent(v)) {
                ds.union(u,v);
                ans += wt;
            }
        }
        return ans;
    }
}

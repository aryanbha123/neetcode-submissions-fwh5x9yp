class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums) {
            map.put(i , map.getOrDefault(i,0)+1);
        }

        int []ans = new int[k];
        PriorityQueue<int []> pq = new PriorityQueue<>((aryan,nitya) -> aryan[1] - nitya[1]);
        for(int i : map.keySet()) {
            pq.add(new int[]{i, map.get(i)});

            if(pq.size() > k) pq.poll();
        }
        int size = pq.size();
        for(int i = 0 ; i< size; i++){
            int []temp = pq.poll();
            ans[k-1] = temp[0];
            k--;
        }

        return ans;
    }    
}

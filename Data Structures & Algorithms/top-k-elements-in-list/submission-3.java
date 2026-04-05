class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1 : freq Map
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        // Step 2 : Key Set traverse krke priroity queue
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(int key : map.keySet()){
            int val = map.get(key);
            pq.add(new int[]{key ,val});

            if(pq.size() > k) pq.poll();
        }
        int []ans = new int[k];
        int size = pq.size();
        for(int i = 0; i < size; i++){
            int []temp = pq.poll();
            ans[k-1] = temp[0];
            k--;
        }
        return ans;
    }    
}

class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    public int lastStoneWeight(int[] stones) {
        

        for(int i: stones){
            maxHeap.offer(i);
        }
        return check();

    }


    private int check(){
        while(maxHeap.size() >1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if(first!= second){
                first = first - second;
                 maxHeap.offer(first);
            }
        }
        
        return maxHeap.isEmpty()? 0 : maxHeap.peek();


    }
}

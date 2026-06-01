class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seq = new HashSet<Integer>();
        int length =0;
        for(int i =0;i<nums.length;i++){
            seq.add(nums[i]);
        }        

        for(int entry: seq){
            if(!seq.contains(entry-1)){
                int longs = 1;
                while(seq.contains(entry + longs)){
                    longs++;
                }
                 length = Math.max(length,longs);
            }
           
        }
        return length;
    }
}

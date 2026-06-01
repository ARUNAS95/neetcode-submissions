class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(!result.containsKey(nums[i]))
            {
                result.put(nums[i],1);
            }
            else {
                result.put(nums[i], result.get(nums[i])+1);
            }
        }
        for(Map.Entry<Integer, Integer> i: result.entrySet()){
            if(i.getValue()>1){
                return true;
            }
        }
    return false;
    }
}
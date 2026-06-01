class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> a = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(a.containsKey(diff)){
                return new int []{a.get(diff),i};
            }
            a.put(nums[i],i);
        }

        
        return new int[]{0,0};
    }
}

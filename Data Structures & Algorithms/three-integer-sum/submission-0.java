class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j = i+1;
            int k= nums.length-1;
            while(j<k){
                int checkSum = nums[i]+nums[j]+nums[k];
                if(checkSum == 0){
                
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if(checkSum < 0){
                    j++;
                } else if(checkSum >0){
                    k--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}

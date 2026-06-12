class Solution {
    public int findMin(int[] nums) {
        int lb = 0;
        int ub = nums.length - 1;
        int res =nums[0];

        while(lb <= ub){
            if(nums[lb] < nums[ub]){
                res = Math.min(res, nums[lb]);
                break;
            }

            int mid = lb + (ub - lb)/2;
            res = Math.min(res, nums[mid]);
            if(nums[mid] >=nums[lb]){
                lb = mid+1;
            } else {
                ub = mid-1;
            }
        }
        return res;
       
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length;
        int lb = 0;
        int up= matrix.length * col -1;
        while(lb<=up){
            int mid = (lb+up)/2;
            int value = matrix[mid/col][mid%col];
            if(value == target){
                return true;
            } else if(value < target){
                lb = mid+1;
            } else {
               up = mid -1;
            }
        }
        return false;
    }
}

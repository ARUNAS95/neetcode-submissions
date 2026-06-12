class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lb = 1;
        int ub = Arrays.stream(piles).max().getAsInt();
        int res = ub;

        while(lb<=ub){
            int mid = (lb+ub )/2;

            int time = 0;
            for(int i: piles){
                time += Math.ceil((double)i / mid);
            }
            if(time<= h){
                res = mid;
                ub = mid-1;
            } else{
                lb = mid+1;
            }
        }
        return res;
    }
}

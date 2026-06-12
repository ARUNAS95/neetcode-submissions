class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleet=0;
        int n = position.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<position.length;i++){
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int []a, int []b){
                return b[0]-a[0];
            }
        });

        double maxTime =0.0;
        for(int i=0;i<arr.length;i++){
            double time = (double)(target - arr[i][0]) / arr[i][1];

            if(time> maxTime){
                fleet++;
                maxTime = time;
            }
        }

        return fleet;

    }
}

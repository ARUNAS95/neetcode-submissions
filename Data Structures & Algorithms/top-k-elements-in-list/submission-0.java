class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> counts = new HashMap<>();
        for(int i =0;i<n;i++){
            if(!counts.containsKey(nums[i])){
                counts.put(nums[i],1);
            } else {
                counts.put(nums[i],counts.get(nums[i])+1);
            }
        }

        Map<Integer, Integer> sortedMap = counts.entrySet()
        .stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .collect(Collectors.toMap(
            e -> e.getKey(),
            e -> e.getValue(),
            (e1,e2) -> e1,
            LinkedHashMap::new)
        );

int[] result = new int[k];
int i = 0;

for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
    if (i < k) {
        result[i++] = entry.getKey();
    } else {
        break;
    }
}
return result;
    }
}
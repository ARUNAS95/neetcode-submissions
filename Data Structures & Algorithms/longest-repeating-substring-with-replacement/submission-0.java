class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right<s.length();right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c,0)+1);

            int maxFre = 0;
            for(int val: map.values()){
                maxFre = Math.max(maxFre, val);
            }

            while((right - left +1) - maxFre > k){
                char remove = s.charAt(left);
                if(map.get(remove)==0){
                    map.remove(remove);
                }
                map.put(remove, map.get(remove)-1);

                left++;

                int maxFreq = 0;
            for(int i : map.values()){
                maxFreq = Math.max(maxFreq, i);
            }
            }
            res = Math.max(res, right-left+1);
        }
        return res;
        
    }
}

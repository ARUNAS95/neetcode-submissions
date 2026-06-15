class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
         if(strs.length == 0 || strs == null){
            return res; 
         }
         int[] nos = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 
         31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

         Map<Integer, List<String>> map = new HashMap<>();
         for(String word : strs){
            int prod = 1;
            for(int i =0;i<word.length();i++){
                prod *= nos[word.charAt(i) - 'a'];
            }
            if(map.containsKey(prod)){
                map.get(prod).add(word);
            }else{
                map.put(prod, new ArrayList<String>());
                map.get(prod).add(word);
            }
         }

         for(List<String> vals: map.values()){
            res.add(vals);
         }

        return res;
    }
}

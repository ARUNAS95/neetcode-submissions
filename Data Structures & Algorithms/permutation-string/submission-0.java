class Solution {
    public boolean checkInclusion(String s1, String s2) {
        

        if(s1.length() > s2.length()){
            return false;
        }

        int[] freq = new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i) - 'a']++;
        }

        int[] windowFre = new int[26];
        int left = 0;

        for(int right = 0; right< s2.length();right++){
            windowFre[s2.charAt(right) - 'a']++;

            if(right - left +1 > s1.length()){
                windowFre[s2.charAt(left) -'a']--;

                left++;
            }

            if(right - left+1 == s1.length()){
                if(isSame(freq, windowFre)){
                    return true;
                }
            }
        }
        return false;
        
    }

    private boolean isSame(int[]a, int[]b){
        for(int i=0;i<26;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}

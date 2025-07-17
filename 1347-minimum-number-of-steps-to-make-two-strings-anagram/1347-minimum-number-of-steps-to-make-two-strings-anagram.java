class Solution {
    public int minSteps(String s, String t) {
        int array[] = new int[s.length()];
        int word1[] = new int[26];
        int word2[] = new int[26];
        for(int i=0;i<s.length();i++){
            int w1 = (int)s.charAt(i)-97;
            int w2 = (int)t.charAt(i)-97;
            word1[w1] = word1[w1]+1;
            word2[w2] = word2[w2]+1;
        } 
        int count = 0;
        for(int i=0;i<26;i++){
            if(word1[i]>word2[i]){
                count = count+(word1[i]-word2[i]);
            }
        }
        return count;
    }
}
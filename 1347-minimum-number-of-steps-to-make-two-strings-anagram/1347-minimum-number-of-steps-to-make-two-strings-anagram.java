class Solution {
    public int minSteps(String s, String t) {
        int array[] = new int[s.length()];
        int word[] = new int[26];
        for(int i=0;i<s.length();i++){
            int w1 = (int)s.charAt(i)-97;
            int w2 = (int)t.charAt(i)-97;
            word[w1] = word[w1]+1;
            word[w2] = word[w2]-1;
        } 
        int count = 0;
        for(int i=0;i<26;i++){
            if(word[i]>0){
                count = count+(word[i]);
            }
        }
        return count;
    }
}
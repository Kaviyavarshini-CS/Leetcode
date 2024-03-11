class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i;
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[strs.length-1];
        String result="";
        for(i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)==s2.charAt(i))
                result=result+s1.charAt(i);
            else
                break;
        }
        return result;
    }
}
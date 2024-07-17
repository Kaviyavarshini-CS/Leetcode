class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int end=0;
        int len=0;
        Set<Character> visit=new HashSet<>();
        while(end<s.length())
        {
            char c=s.charAt(end);
            while(visit.contains(c))
            {
                visit.remove(s.charAt(start));
                start++;
            }
            visit.add(c);
            end++;
            int l=end-start;
            len=Math.max(len,l);
        }
        return len;
    }
}
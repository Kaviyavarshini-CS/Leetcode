class Solution {
    public String shortestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        int end = s.length()-1;
        int start = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(start)==s.charAt(end)){
                start++;
            }
            end--;
        }

        if (start == s.length()) return s;

        String sufix = s.substring(start);
        String prefix = new StringBuffer(sufix).reverse().toString();
        String midString = shortestPalindrome(s.substring(0,start));

        return prefix + midString + sufix;
    }
}
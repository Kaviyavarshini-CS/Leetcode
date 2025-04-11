class Solution {
    public boolean isPalindrome(int x) {
        String s1 = Integer.toString(x);
        StringBuffer sb = new StringBuffer(s1);
        String s2 = sb.reverse().toString();
        if(s1.equals(s2)){
            return true;
        }
        else{
            return false;
        }
    }
}
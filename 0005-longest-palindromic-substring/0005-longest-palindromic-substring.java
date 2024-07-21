class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) 
        {
            return s;
        }

        String longestPalindrome = "";

        for (int i = 0; i < s.length(); i++) 
        {
            String oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome.length() > longestPalindrome.length()) 
            {
                longestPalindrome = oddPalindrome;
            }
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            if (evenPalindrome.length() > longestPalindrome.length()) 
            {
                longestPalindrome = evenPalindrome;
            }
        }

        return longestPalindrome;
    }

    private String expandAroundCenter(String s, int low, int high) 
    {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) 
        {
            low--;
            high++;
        }
        return s.substring(low + 1, high);
    }
}
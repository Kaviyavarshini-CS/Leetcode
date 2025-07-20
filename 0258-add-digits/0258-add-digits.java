class Solution {
    public int addDigits(int num) {
        int rem = 0;
        int d = num;
        while(d/10!=0){
            num = d;
            int sum = 0;
            while(num>0){
                rem = num%10;
                sum = sum+rem;
                num = num/10;
            }
            d = sum;
        }
        return d;
    }
}
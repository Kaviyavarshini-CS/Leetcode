int arrangeCoins(int n) {
    int count=0;
    int coins=n;
    int staircase=1;
    while(coins>0)
    {
        coins=coins-staircase;
        staircase=staircase+1;
        count=count+1;
        if(staircase>coins)
        {
            return count;
        }
    }
    return 0;
}
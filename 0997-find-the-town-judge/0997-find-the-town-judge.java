class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n+1];
        for(int[] t : trust){
            int a = t[0];
            int b = t[1];
            count[a] = count[a]-1;
            count[b] = count[b]+1;
        }
        for(int i=1;i<=n;i++){
            if(count[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}
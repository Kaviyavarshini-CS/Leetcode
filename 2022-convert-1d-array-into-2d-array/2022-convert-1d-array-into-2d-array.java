class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(n*m!=original.length){
            return new int[0][0];
        }
        int[][] arr = new int[m][n];
        int i, j;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                arr[i][j] = original[(i*n)+j];
            }
        }
        return arr;
    }
}
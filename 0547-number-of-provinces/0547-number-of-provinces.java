class Solution {
    public void dfs(int[][] isConnected, boolean[] visited, int city){
        visited[city] = true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[city][i]==1 && (!visited[i])){
                dfs(isConnected, visited, i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        int province = 0;
        boolean[] visited = new boolean[size];
        for(int i=0;i<size;i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                province = province+1;
            }
        }
        return province;
    }
}
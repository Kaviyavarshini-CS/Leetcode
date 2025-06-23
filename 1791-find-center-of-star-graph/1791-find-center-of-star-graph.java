class Solution {
    public int findCenter(int[][] edges) {
        int node[] = new int[edges.length+2];
        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            node[a] = node[a]+1;
            node[b] = node[b]+1;
        }
        for(int i=0;i<=edges.length+2;i++){
            if(node[i]==edges.length){
                return i;
            }
        }
        return -1;
    }
}
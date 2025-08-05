class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int index = 0;
        int start = 0;
        int end = start+1;
        int answer[] = new int[temperatures.length];
        while(start<temperatures.length-1){
            if(start>0 && temperatures[start]==temperatures[start-1]){
                if(answer[start-1]==0){
                    answer[start] = 0;
                }
                else{
                    answer[start] = answer[start-1]-1;
                }
                
                start = start+1;
                end = start+1;
            }
            else if(end>=temperatures.length){
                answer[start] = 0;
                start = start+1;
                end = start+1;
            }
            else if(temperatures[start]<temperatures[end]){
                answer[start] = end-start;
                start = start+1;
                end = start+1;
            }
            else{
                end = end+1;
            }
        }
        return answer;
    }
}
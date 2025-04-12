class Solution {
    public String convert(String s, int numRows) {
        if(s.length()<=1 || numRows>=s.length()){
            return s;
        }
        StringBuilder sb[] = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            sb[i] = new StringBuilder();
        }
        int current = 0;
        boolean direction = false;
        for(char c : s.toCharArray()){
            sb[current].append(c);
            if(current==0 || current==numRows-1){
                direction = !direction;
            }
            if(direction==true){
                current = current+1;
            }
            if(direction==false){
                current = current-1;
            }
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder res : sb){
            result.append(res);
        }
        return result.toString();
    }
}
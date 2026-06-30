class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(int i = 0; i<sentences.length; i++){
            String[]str = sentences[i].split(" ");
            int len = str.length;
            if(max<len){
                max = len;
            }

        }
        return max;
        
    }
}

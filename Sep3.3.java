class Solution {
    public int[] diStringMatch(String s) {
       int n = s.length();
       int low = 0;
       int high = n;
       int[]res = new int[n+1];
       for(int i = 0; i<n; i++){
        if(s.charAt(i)=='I'){
            res[i] = low++;

        }
        else if(s.charAt(i)=='D'){
            res[i] = high--;
        }
       }
       res[n] = low;
       return res;
        
    }
}

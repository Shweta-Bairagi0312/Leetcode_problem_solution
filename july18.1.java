class Solution {
    public int myAtoi(String s) {
        if(s== null ||s.length()==0){
            return 0;
        }
        int maxi = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        int i = 0;
        int n = s.length();

        while(i<n && s.charAt(i) == ' '){
            i++;
        }
         if(i==n){
           return 0; 
         }

        int sign = 1;
        if(s.charAt(i)=='+'){
            i++;

        }
        else if(s.charAt(i)=='-'){
            sign  = -1;
            i++;
        }
        long res = 0;
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i)-'0';
            res = res*10+digit;
            if(sign *res<= min){
               return min;
            }
            if( sign *res >=maxi){
                return maxi;
            }
            i++;

        }
        return(int)(res*sign);



    }
}

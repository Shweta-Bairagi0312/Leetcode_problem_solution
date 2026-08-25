class Solution {
    public String predictPartyVictory(String senate) {
        int i = 0;
        int n = senate.length();
        StringBuilder sb = new StringBuilder();
        int d = 0;
        int r = 0;
        int dcount = 0;
        int rcount = 0;
        while(i<n){
            if(senate.charAt(i)=='D'){
                dcount++;
                if(r>0){
                    r--;
                }else{
                    sb.append('D');
                    d++;
                }
            }else{
                rcount++;
                if(d>0){
                    d--;
                }else{
                    sb.append('R');
                    r++;
                }
            }
            i++;
        if(i==n){
            senate = sb.toString();
            n = sb.length();
            i = 0;
            if(dcount==0){
                return "Radiant";
            }else if(rcount == 0){
                return "Dire";
            }

            sb = new StringBuilder();
            dcount = 0;
            rcount = 0;
        }

        }
        return "";
        

    }
}

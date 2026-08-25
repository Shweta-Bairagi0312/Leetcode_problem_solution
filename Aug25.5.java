class Solution {
    public String predictPartyVictory(String senate) {
     int n = senate.length();
     ArrayDeque<Integer>rad = new ArrayDeque<>();
     ArrayDeque<Integer>dire = new ArrayDeque<>();

     for(int i = 0; i<n; i++){
        if(senate.charAt(i)=='R'){
            rad.offer(i);
        }
        else{
            dire.offer(i);
        }
     }
     while(!rad.isEmpty() && ! dire.isEmpty()){
        int r = rad.poll();
        int d = dire.poll();
        if(r<d){
            rad.offer(r+n);
        }
        else{
            dire.offer(d+n);
        }
     }

        return rad.isEmpty()? "Dire":"Radiant";

    }
}

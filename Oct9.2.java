import java.util.*;

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        
        double[][]ratio = new double[val.length][2];
        
        for(int i = 0; i<val.length; i++){
            ratio[i][0] = (double) val[i]/wt[i];
            ratio[i][1] = i;
        }
        Arrays.sort(ratio,(a,b)->Double.compare(b[0],a[0]));
        
        double profit = 0;
        for(int i = 0; i<val.length && capacity>0; i++){
            int idx = (int) ratio[i][1];
            
            if(wt[idx]<=capacity){
                profit += val[idx];
                capacity -= wt[idx];
            }
            else{
                profit += capacity*ratio[i][0];
                capacity = 0;
            }
        }
        return profit;
        
        
    }
}

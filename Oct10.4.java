class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        Arrays.sort(bills);
        for(int i = 0;i<bills.length; i++){
            if(bills[i]==5){
                count5++;
            }
            if(bills[i]==10){
                if(count5==0){
                    return false;
                }
                count5--;
                count10++; 
            }
            if(bills[i]==20){
                if(count5==0 && count10==0){
                    return false;
                }
                count5--;
                count10--; 
            }
        }
        return true;
    }
}

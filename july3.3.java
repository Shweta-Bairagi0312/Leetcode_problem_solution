class Solution {
    public boolean isBalanced(String num) {
        char[]ch = num.toCharArray();
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i<ch.length; i++){
            if(i%2==0){
                sum1 += Character.getNumericValue(ch[i]);

            }
            else{
                sum2 += Character.getNumericValue(ch[i]);

            }
        }
        return sum1==sum2;

    }
}

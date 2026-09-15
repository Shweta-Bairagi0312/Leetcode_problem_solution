class Solution {
    public double myPow(double x, int n) {
        long power = n;

        if(power == 0){
            return 1;
        }

        if(power < 0){
            return 1 / myPow(x, (int)(-power));
        }

        double half = myPow(x, (int)(power / 2));

        if(power % 2 == 0){
            return half * half;
        }
        else{
            return half * half * x;
        }
    }
}

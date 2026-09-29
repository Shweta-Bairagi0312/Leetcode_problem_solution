class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return solve(x,N);
    }
    public double solve(double x, long power){
        if(power==0){
            return 1;
        }
        if(power<0){
            return(1/solve(x,-power));
        }
        double half = solve(x,power/2);

        double ans = 0;
        if(power%2==0){
            ans = half*half;
        }
        else{
            ans = half*half*x;
        }
        return ans;
    }
}

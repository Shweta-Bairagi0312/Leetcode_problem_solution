class Solution {
    public int maxCharGap(String s) {
        // code here
        int n=s.length();
        int a[]=new int[26],res=-1;
        Arrays.fill(a,-1);
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(a[ch-'a']==-1){
                a[ch-'a']=i;
            }
            else{
                res=Math.max(res,i-a[ch-'a']-1);
            }
        }
        return res;
    }
};

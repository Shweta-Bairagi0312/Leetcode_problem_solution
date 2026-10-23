class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->Integer.compare(a[1],b[1]));
        int last = pairs[0][1];
        int countpair = 1;
        for(int i = 1; i<pairs.length; i++){
            int[]pair = pairs[i];
            if(pair[0]>last){
                countpair++;
                last = pairs[i][1];
            }
        }
        return countpair;
    }
}

class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[]ans = new int[n];
        Arrays.fill(ans,-1);

        List<Integer>list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(s.charAt(i)==c){
                list.add(i);
            }
        }
        for(int i = 0; i<list.size(); i++){
            int num = list.get(i);
            countDis(ans, num);
        }
        return ans;

    }
    public static void countDis(int[]ans, int num){
        for(int i = 0; i<ans.length; i++){
            if(ans[i]==-1||ans[i]>Math.abs(num-i)){
            ans[i] = Math.abs(num-i);

        }
        }
    }
}

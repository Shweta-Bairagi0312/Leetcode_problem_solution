class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>res = new ArrayList<>();
        makePartition(s,0,new ArrayList<>(),res);
        return res;
    }
    public void makePartition(String s,int start,List<String>list,List<List<String>>res){
        if(start==s.length()){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int end = start+1; end<=s.length(); end++){
            if(isPalindrome(s,start,end-1)){
                list.add(s.substring(start,end));
                makePartition(s,end,list, res);
                list.remove(list.size()-1);
            }
        }

    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)){
            return false;
        }
        }
        return  true;
    }
}

class Solution {
    public boolean isSubstringPresent(String s) {
        String sb = new StringBuilder(s).reverse().toString();
        for(int i = 0; i<s.length()-1; i++){
            String rev = s.substring(i,i+2);

            if(sb.contains(rev)){
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public int minimumSum(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;

        int f = 0;
        char last = ' ';
        while (i <= j) {
            
            char left = s.charAt(i);
            char right = s.charAt(j);
            
            if (left != '?' && right != '?' && left != right)
                return -1;
            else if (left != '?') {
                f = 1;
                last = left;
                break;
            } else if (right != '?') {
                f = 1;
                last = right;
                break;
            }
            i++;
            j--;
        }
        if (f == 0)
            return 0; // whole string is made up of '?'

        i = 0;
        j = n - 1;
        int ans = 0;
        while (i <= j) {
            
            char left = s.charAt(i);
            char right = s.charAt(j);
            
            if (left != '?' && right != '?' && left != right) {
                return -1;
            } else if (left != '?' && right != '?' && left == right && left != last) {
                ans += Math.abs(left - last);
                last = left;
            } else if (left != '?' && right == '?' && left != last) {
                ans += Math.abs(left - last);
                last = left;
            } else if (right != '?' && left == '?' && right != last) {
                ans += Math.abs(right - last);
                last = right;
            } else if (i == j && left != last) {
                ans += Math.abs(right - last);
                last = right;
            }
            i++;
            j--;
        }
        return ans * 2;
    }
}

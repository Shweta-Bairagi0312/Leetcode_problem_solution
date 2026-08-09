
class Solution {

    public int maxTask(int[] h, int[] l) {

        int n = h.length;

        int p0 = 0, p1 = 0;

        int c0 = 0, c1 = 0;        

        for(int ind = n-1;ind >= 0;ind--)

        {

            c1 = Math.max(l[ind] + p1, p0);

            c0 = Math.max(h[ind] + p1, c1);

            p0 = c0;

            p1 = c1;

        }

        return p0;

    }

}


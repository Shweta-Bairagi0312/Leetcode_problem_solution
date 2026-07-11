class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        ArrayList<Integer>list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<a.length && j<b.length){
            if(i>0 && a[i]==a[i-1]){
               
                i++;
                continue;
            }
            if(j>0 && b[j]==b[j-1]){
               
                j++;
                 continue;
            }
            
            if(a[i]<b[j]){
                list.add(a[i]);
                i++;
            }
            else if(b[j]<a[i]){
                list.add(b[j]);
                j++;
            }
            else{
                list.add(a[i]);
                i++;
                j++;
            }
        }
        while(i<a.length){
            if(i==0||a[i]!= a[i-1]){
                list.add(a[i]);
              
            }
              i++;
        }
        while(j < b.length){
            if(j == 0 || b[j] != b[j-1]){
                 list.add(b[j]);
            }
            j++;
               
           
        }
    
        return list;
    }
}

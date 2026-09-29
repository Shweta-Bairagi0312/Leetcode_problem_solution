public class Len{
    public static int strLength(String str , int indx,int count){
        if(indx==str.length()){
            return count;
        }
        return strLength(str, indx+1, count+1);
    }
    public static void main(String[]args){
        String str = "shweta";
        int res = strLength(str,0,0);
        System.out.println(res);

    }
}

public class Len{
    public static int strLength(String str){
        if(str.length()==0){
            return 0;
        }
       return strLength(str.substring(1)) +1;
    }
    public static void main(String[]args){
        String str = "shweta";
        int res = strLength(str);
        System.out.println(res);

    }
}

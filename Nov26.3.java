public static String reverseAlternateWords(String str){
    String[]words = str.split(" ");
    boolean flag = true;
    StringBuilder res = new StringBuilder();
    for(int i = 0; i<words.length; i++){
        if(flag){
           res.append(reverse(words[i]));
        }
        else{
            res.append(words[i]);
        }
         if (i != words.length - 1) {
            res.append(" ");
        }
        flag = !flag;
    }
   
    return words.toString();
} 

public static String reverse(String str){
   String rev = "";
   for(int i = str.length()-1; i>=0; i--){
    rev += str.charAt(i);

   }
   return rev;
}


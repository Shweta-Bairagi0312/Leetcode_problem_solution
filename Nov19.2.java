import java.util.*;

class Solution {
    public static  class Info{
        Node node;
        int hd;
        
        public Info(Node node, int hd){
            this.node = node;
            this.hd =  hd;
        }
    
    }
    public ArrayList<Integer> topView(Node root) {
        Queue<Info>Q = new LinkedList<>();
        Map<Integer,Node>map = new HashMap<>();
        
        
        Q.add(new Info(root,0));
        int min = 0;
        int max = 0;
        
        while(!Q.isEmpty()){
            Info curr = Q.poll();
            
            if(!map.containsKey(curr.hd)){
                map.put(curr.hd,curr.node);
            }
            
            if(curr.node.left != null){
               Q.add(new Info(curr.node.left, curr.hd-1));
                min = Math.min(min,curr.hd-1);
            }
            if(curr.node.right != null){
                Q.add(new Info(curr.node.right, curr.hd+1));
                max = Math.max(max,curr.hd+1);
            }
            
        }
        ArrayList<Integer>list = new ArrayList<>();
        for(int i = min; i<=max; i++){
            list.add(map.get(i).data);
        }
        return list;
        
    }
}

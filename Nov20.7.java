class Solution {
    public static class Info{
        Node node;
        int hz;
        
        Info(Node node, int hz){
            this.node = node;
            this.hz = hz;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        
        
        // code here
        ArrayList<Integer>list = new ArrayList<>();
        
        if(root==null){
            return list;
        }
        Queue<Info>Q = new LinkedList<>();
        Q.add(new Info(root,0));
        
        Map<Integer,Integer>map = new TreeMap<>();
        
        while(!Q.isEmpty()){
            Info curr = Q.poll();
            int val = curr.node.data;
            int hd = curr.hz;
            
            map.put(hd,val);
            
            if(curr.node.left != null){
                Q.add(new Info(curr.node.left,hd-1));
            }
            
            if(curr.node.right != null){
                Q.add(new Info(curr.node.right,hd+1));
            }
            
            
            
        }
        
        
        for(int val : map.values()){
            list.add(val);
            
        }
        return list;
        
    }
}

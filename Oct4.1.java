class Solution {
    List<List<String>>res = new ArrayList<>();

   public List<List<String>> solveNQueens(int n) {
    char[][]board = new char[n][n];
    for(int i = 0; i<board.length; i++){
        Arrays.fill(board[i],'.');
    }
    genrate(board,0);
    return res;
        
    }
    public void genrate(char[][]board, int row){
        if(row==board.length){
            List<String>list = new ArrayList<>();
            for(int i = 0; i<board.length; i ++){
                list.add(new String(board[i]));
            }
            res.add(list);
            return ;
        }
        for(int col = 0; col<board[row].length; col++){
          if(isSafe(board,row,col)){
            board[row][col] = 'Q';
            genrate(board, row+1);
            board[row][col] = '.';
          }

        }

    }
    public boolean isSafe(char[][]board, int row, int col){
        for(int i = row-1; i>=0; i--){
            if(board[i][col]=='Q') return false;
        }
        for(int i = row-1,j = col-1; i>=0&& j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }

        }
        for(int i = row-1,j = col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }

        }
        return true;
    }
}

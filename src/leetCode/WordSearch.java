package leetCode;

public class WordSearch {
   /* Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell,
    where "adjacent" cells are those horizontally or vertically neighboring.
    The same letter cell may not be used more than once.

            For example,
    Given board =

[
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
        ]
    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.*/

    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        boolean[][] visted=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,0,visted,i,j)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,String word,int index,boolean[][] visted,int row,int colum){
        if(index==word.length()) return true;
        if(row<0||row>=board.length||colum<0 ||colum>=board[0].length||visted[row][colum]) return false;
        char c= word.charAt(index);
        if(board[row][colum]==c){
            visted[row][colum]=true;
            if(dfs(board,word,index+1,visted,row+1,colum)||dfs(board,word,index+1,visted,row-1,colum)
                ||dfs(board,word,index+1,visted,row,colum+1)||dfs(board,word,index+1,visted,row,colum-1))
                return true;
            visted[row][colum]=false;
        }
        return false;
    }
}

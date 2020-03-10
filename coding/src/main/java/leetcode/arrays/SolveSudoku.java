package leetcode.arrays;

import java.util.HashMap;

public class SolveSudoku {

	HashMap<String,Integer> rows = new HashMap<String,Integer>();
 	HashMap<String,Integer> columns = new HashMap<String,Integer>();
	
	
	public static void main(String[] args) {
		char[][] board = new char[][] {{'.','.','.','.','.','.','.','.','.'}
		,{'.','.','.','.','.','.','.','.','.'},
		{'.','9','.','.','.','.','.','.','1'},
		{'8','.','.','.','.','.','.','.','.'},
		{'.','9','9','3','5','7','.','.','.'},
		{'.','.','.','.','.','.','.','4','.'},
		{'.','.','.','8','.','.','.','.','.'},
		{'.','1','.','.','.','.','4','.','9'},
		{'.','.','.','5','.','4','.','.','.'}};
		SolveSudoku isv = new SolveSudoku();
		isv.solveSudoku(board);
	}
	
	public void solveSudoku(char[][] board) {
        for(int i = 0;i <board.length;i++) {
        	boolean[] rows = new boolean[9];
        	for(int j = 0; j < board.length;j++) {
        		if(board[i][j] == '.') {
        			for(int k = 1;k <=9 ;k++) {
        				if(!rows[k]) {
        					board[i][j] = (char)k;
        					if(isValidSudoku(board)) {
        						break;
        					}
        				}
        			}
        		}else {
        			rows[board[i][j]-49] = true;
        		}
        	}
        }
    }

	public boolean isValidSudoku(char[][] board) {
        for(int i = 0 ;i< board.length;i+=3) {
        	for(int j = 0; j< board[i].length;j+=3) {
        		if(!validateBoxes(board,i,i+2,j,j+2)){
        			return false;
        		}
        	}
        }
        return true;
 }
 
 private boolean validateBoxes(char[][] board, int rowStart,int rowEnd,int colStart,int colEnd) {
	 boolean[] box = new boolean[9];
	 for(int i = rowStart;i<=rowEnd;i++) {
		 for(int j = colStart; j <= colEnd;j++) {
			 if(board[i][j] != '.') {
				 if(box[board[i][j]-49]) {
					 return false;
				 }else {
					 box[board[i][j]-49] = true;
					 if(rows.containsKey(board[i][j]+"r"+i)){
						 return false;
					 }
					 if(columns.containsKey(board[i][j]+"c"+j)){
						 return false;
					 }
					 rows.put(board[i][j]+"r"+i,i);
					 columns.put(board[i][j]+"c"+j,j);
				 }
		 	}
		 }
	 }
	 return true;
 }
	
}

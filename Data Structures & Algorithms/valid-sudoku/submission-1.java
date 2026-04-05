class Solution {
    // brute force

    boolean checkBox(char [][]board,int i , int j) {
        //  i =0 , j = 0
        // [0][var 0-9]
        char elem = board[i][j];
        for(int var = 0; var < 9; var++) {
            if(j == var) continue;
            if(elem == board[i][var]) return false;
        }
        for(int var = 0 ; var < 9; var++) {
            if(i == var) continue;
            if(elem == board[var][j]) return false;
        }

        // (4,5) 4/3 = 1 , 5/3 = 1 (1,1)
        int mid = (i/3)*3;
        int nid = (j/3)*3;
        for(int m = mid ; m < mid+3; m++){
            for(int n = nid ; n < nid+3 ; n++) {
                if(m == i && n == j) continue;
                else if(board[m][n] == elem) return false;
            }
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int m = board.length; // no of rows
        int n = board[0].length; // no of colos

        //  worst approch
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++) {
                if (board[i][j] == '.') continue; // ✅ skip empty cells
                if(!checkBox(board, i, j)) return false;
            }
        }
        return true;
    }
}

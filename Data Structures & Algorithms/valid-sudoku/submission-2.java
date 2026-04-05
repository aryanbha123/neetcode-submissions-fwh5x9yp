class Solution {
    // brute force

   
    public boolean isValidSudoku(char[][] board) {
        HashMap<String, Set<Character>> map = new HashMap<>();

        for(int i =0 ; i < 9 ;i++) {
            for(int j = 0 ; j < 9 ; j++) {

                map.put("R"+i , new HashSet<>());
                map.put("C"+j , new HashSet<>());
                map.put("B"+(i/3)+(j/3) , new HashSet<>());
            }
        }
        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0; j < 9 ; j++) {
                if(board[i][j] == '.') continue;
                // "1"+"1" == "11"
                // "R"+I = "R"
                char elem = board[i][j];
                String rowKey = "R"+i;
                String colKey = "C"+j;
                String boxKey = "B"+(i/3)+(j/3);

                if(!map.get(rowKey).add(elem))  return false;
                if(!map.get(colKey).add(elem))  return false;
                if(!map.get(boxKey).add(elem))  return false;
                
            }
        }

        return true;
    
    }
}

//N-QUEENS PROBLEM:-

public class N_QUEENS {
    public static void main(String[] args) {
        int n=4;
        if (n < 4) {
            System.out.println("No Answer found!");
        }
        boolean[][] board=new boolean[n][n];

        System.out.println(queens(board,0));
    }
    static  int queens(boolean[][] board, int row){
        if (row == board.length) {
            displaay(board);
            System.out.println();
            return 1;
        }


        int count=0;

        //placing the queen and checking for every row and column

        for (int col = 0; col< board.length; col++){
            //place the queen if it is in safe place
            if (isSafe(board,row,col)){
                board[row][col]=true;
                count +=queens(board, row+1);
                board[row][col]=false;
            }
        }
        return count;

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //check vertical row first
        for (int i=0; i<row; i++){
            if (board[i][col]){
                return false;
            }
        }

        //check for diagonal left
        int maxleft=Math.min(row,col);
        for (int i=1; i<=maxleft; i++){
            if (board[row-i][col-i]){
                return false;

            }
        }

        //check for diagonal right
        int maxright=Math.min(row, board.length-col-1);
        for (int i=1; i<=maxright; i++){
            if (board[row-i][col+i]){
                return false;

            }
        }
        return true;

        //we could have also written:-

        // diagonal left
//        int r = row;
//        for(int c = col;c>=0&&r>=0;c--,r--){
//            if(board[r][c]){
//                return false;
//            }
//        }
//
        // diagonal right
//        r = row;
//        for(int c = col;c<board.length&&r>=0;c++,r--){
//            if(board[r][c]){
//                return false;
//            }
//        }
    }

    private static void displaay(boolean[][] board) {
        for(boolean [] row:board){
            for (boolean element:row){
                if (element){
                    System.out.print("Q ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
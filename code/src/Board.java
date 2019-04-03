import java.util.*;

public class Board {
    public static boolean checkWon(int[][] board) {
        // write code here
        if( (board[0][0]==1 && board[0][1]==1 && board[0][2]==1)  ||
                (board[1][0]==1 && board[1][1]==1 && board[1][2]==1) ||
                (board[2][0]==1 && board[1][2]==1 && board[2][2]==1)
                ){
            return true;
        }else if ( (board[0][0]==1 && board[1][0]==1 && board[2][0]==1) ||
                (board[2][0]==1 && board[1][2]==1 && board[2][2]==1) ||
                (board[1][0]==1 && board[1][1]==1 && board[1][2]==1) ){
            return true;
        }else if (board[1][1]==1){
            if ( ((board[0][0]==1)&&(board[2][2]==1)) || ( (board[0][2]==1)&&(board[2][0]==1))){
                return  true;
            }else {
                return false;
            }
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        String str=scanner.nextLine();
//        str=str.replaceAll(String.valueOf('['),"");
//        str=str.replaceAll("]","");
//        System.out.println(str);
        int[][] arr1={{1,0,1},{1,-1,-1},{1,-1,0}};
        int[][] arr2={{1,0,1},{0,1,-1},{1,-1,1}};
        System.out.println(checkWon(arr1));
    }
}
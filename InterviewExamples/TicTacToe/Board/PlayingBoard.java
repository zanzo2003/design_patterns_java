package InterviewExamples.TicTacToe.Board;

import InterviewExamples.TicTacToe.Helper.Pair;
import InterviewExamples.TicTacToe.PlayingPiece.PlayingPiece;

import java.util.ArrayList;
import java.util.List;


public class PlayingBoard {

    private int size;
    private PlayingPiece[][] board;

    public PlayingBoard( int size ){
        this.size = size;
        this.board = new PlayingPiece[this.size][this.size];
    }

    public boolean addPiece( int r, int c, PlayingPiece piece){
        if(!validatePosition( r,  c)) return false;
        board[r][c] = piece;
        return true;
    }

    public void showBoard(){
        for( int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                String pieceType = this.board[row][col].getPieceType().name();
                System.out.println(pieceType + " ");
            }
            System.out.println("\n");
        }
    }

    public List<Pair<Integer, Integer>> getEmptyCells(){
        List<Pair<Integer, Integer>> emptyCells = new ArrayList<>();
        for( int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                PlayingPiece piece = this.board[row][col];
                if(piece == null) emptyCells.add(new Pair<>(row, col));
            }
        }
        return emptyCells;
    }

    private boolean validatePosition(int r, int c){
        return validateInput(r, c) && board[r][c] != null;
    }

    private boolean validateInput(int r, int c){

        return ( (r >= 0 && r < size) && (c >= 0 && c < size) ) ;
    }
}

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

    public int getSize(){
        return size;
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



    public boolean checkForWinner(int row, int column, PlayingPiece pieceType){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // Check Row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == null ||!board[row][i].pieceType.equals(pieceType)) {
                rowMatch = false;
                break;
            }
        }

        // Check Column
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == null || !board[i][column].pieceType.equals(pieceType)) {
                columnMatch = false;
                break;
            }
        }

        // Check Diagonally
        for (int i = 0, j = 0; i < board.length; i++, j++) {
            if (board[i][j] == null || !board[i][j].pieceType.equals(pieceType) ) {
                diagonalMatch = false;
                break;
            }
        }

        // Check Anti-Diagonally
        for (int i = 0, j = board.length - 1; i < board.length; i++, j--) {
            if (board[i][j] == null || board[i][j] != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

    }

    private boolean validatePosition(int r, int c){
        return validateInput(r, c) && board[r][c] != null;
    }

    private boolean validateInput(int r, int c){

        return ( (r >= 0 && r < size) && (c >= 0 && c < size) ) ;
    }
}

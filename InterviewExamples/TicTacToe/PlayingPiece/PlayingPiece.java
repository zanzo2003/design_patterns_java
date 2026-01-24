package InterviewExamples.TicTacToe.PlayingPiece;

public class PlayingPiece {

    public PieceType pieceType;


    public PlayingPiece( PieceType type){
        this.pieceType = type;
    }

    public PieceType getPieceType(){
        return this.pieceType;
    }
}

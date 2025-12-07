package InterviewExamples.TicTacToe;

import InterviewExamples.TicTacToe.Board.PlayingBoard;
import InterviewExamples.TicTacToe.PlayingPiece.OPlayingPiece;
import InterviewExamples.TicTacToe.PlayingPiece.PieceType;
import InterviewExamples.TicTacToe.PlayingPiece.XPlayingPiece;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TicTacToeGame {

    private  Deque<Player> playerQueue = new LinkedList<>();

    private  PlayingBoard board;

    public void initilizeGame(){

        Player[] playerList = getPlayers();
        Arrays.stream(playerList).forEach( player-> this.playerQueue.add(player));
        this.board = new PlayingBoard(3);

    }

    public void playGame(){


        boolean noWinner = true;

        while(noWinner){

        }
    }

    private Player[] getPlayers(){
        Player playerOne = new Player("Player 1", new XPlayingPiece());
        Player playerTwo = new Player("Player 2", new OPlayingPiece());
        return new Player[]{playerOne, playerTwo};
    }


}

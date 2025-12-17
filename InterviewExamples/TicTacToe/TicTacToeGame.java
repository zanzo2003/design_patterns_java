package InterviewExamples.TicTacToe;

import InterviewExamples.TicTacToe.Board.PlayingBoard;
import InterviewExamples.TicTacToe.Helper.Pair;
import InterviewExamples.TicTacToe.PlayingPiece.OPlayingPiece;
import InterviewExamples.TicTacToe.PlayingPiece.XPlayingPiece;

import java.util.*;

public class TicTacToeGame {

    private final Deque<Player> playerQueue = new LinkedList<>();
    private final Scanner inputScanner = new Scanner(System.in);
    private  PlayingBoard board;

    public Player winner;

    public void initilizeGame(){

        Player[] playerList = getPlayers();
        Arrays.stream(playerList).forEach( player-> this.playerQueue.add(player));
        this.board = new PlayingBoard(3);

    }

    public GameStatus playGame(){

        boolean noWinner = false;
        while(!noWinner){

            Player currentPlayer = playerQueue.removeFirst();
            board.showBoard();
            List<Pair<Integer, Integer>> freeSpaces = board.getEmptyCells();

            if(freeSpaces.isEmpty()){
                noWinner = true;
                continue;
            }

            System.out.println("Player " + currentPlayer.getName() + " - Please enter [row, column] :");
            String input = inputScanner.nextLine();
            String[] values = input.split(",");
            int row = Integer.valueOf(values[0]);
            int col = Integer.valueOf(values[1]);

            boolean validMove = board.addPiece(row, col, currentPlayer.getPlayingPiece());
            if(!validMove){
                System.out.println("Not a valid move, Please try again!!");
                playerQueue.addFirst(currentPlayer);
                continue;
            }

            playerQueue.addLast(currentPlayer);

            boolean isWinner = board.checkForWinner(row, col, currentPlayer.getPlayingPiece());
            if (isWinner) {
                board.showBoard();
                winner = currentPlayer;
                return GameStatus.WIN;
            }
        }

        return GameStatus.DRAW;
    }


    private Player[] getPlayers(){
        Player playerOne = new Player("Player 1", new XPlayingPiece());
        Player playerTwo = new Player("Player 2", new OPlayingPiece());
        return new Player[]{playerOne, playerTwo};
    }


}

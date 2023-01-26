package pk;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Scanner;

public class Game {
    // initial vars
    private int player1Score;
    private int player2Score;
    private int player1Wins;
    private int player2Wins;
    private int draws;
    private final int scoreToWin;
    private static final Logger logger = LogManager.getLogger(Game.class);
    // private static final String tracer = "trace";

    // Constructor
    public Game() {
        this.player1Score = 0;
        this.player2Score = 0;
        this.player1Wins = 0;
        this.player2Wins = 0;
        this.draws = 0;
        this.scoreToWin = 6000;
    }

    // * Plays the game/runs simulation
    public void play(int gamesCount, boolean tracer, String strategy1, String strategy2) {
        System.out.println("Welcome to Piraten Karpen Simulator!");

        Player player1 = new Player(strategy1);
        Player player2 = new Player(strategy2);

        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Trace Program? (type 'trace' for trace logs): ");
        // String logs = scanner.nextLine();
        // scanner.close();

        for (int i = 0; i < gamesCount; i++) {
            if (tracer) {
                logger.trace("==================================NEW GAME==================================");
            }
            player1Score = 0;
            player2Score = 0;

            while (player1Score < scoreToWin && player2Score < scoreToWin) {
//                 System.out.println("|||||||||||||||||||PLAYER1 SCORE: " + player1Score + "|||||||||||||||||||");
                player1Score += player1.turn();
//                 System.out.println("|||||||||||||||||||PLAYER2 SCORE: " + player2Score + "|||||||||||||||||||");
                player2Score += player2.turn();
            }

//            System.out.println("!!!!!!!!!!!!!No New Turn - Game Has Finished!!!!!!!!!!!!!");
            if(player1Score == player2Score){
                draws++;
                if (tracer){
                    logger.trace("DRAW");
                }
            }
            else if (player1Score >= scoreToWin && player1Score > player2Score) {
                player1Wins++;
                if (tracer){
                    logger.trace("Player 1 Wins");
                }
            } else {
                player2Wins++;
                if (tracer){
                    logger.trace("Player 2 Wins");
                }
            }
            if (tracer){
                logger.trace("Player 1 Final Score: " + player1Score);
                logger.trace("Player 2 Final Score: " + player2Score);
            }

        }

        double player1WinPercent = Math.round((player1Wins * 1.0 / gamesCount)*100.0);
        double player2WinPercent = Math.round((player2Wins * 1.0 / gamesCount)*100.0);

        if (tracer){
            logger.trace("Player 1 Wins: " + player1Wins);
            logger.trace("Player 2 Wins: " + player2Wins);
            logger.trace("Number of Draws: " + draws);
        }
        System.out.println("\nPlayer 1 Win Percentage: " + player1WinPercent + "%");
        System.out.println("Player 2 Win Percentage: " + player2WinPercent + "%");

        System.out.println("That's all folks!");
    }
}

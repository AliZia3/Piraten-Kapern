package pk;

public class Game {
    // initial vars
    private int player1Score;
    private int player2Score;
    private int player1Wins;
    private int player2Wins;
    private int scoreToWin;

    // Constructor
    public Game() {
        this.player1Score = 0;
        this.player2Score = 0;
        this.player1Wins = 0;
        this.player2Wins = 0;
        this.scoreToWin = 6000;
    }

    // * Plays the game/runs simulation
    public void play(String player1, String player2, int gamesCount) {
        System.out.println("Welcome to Piraten Karpen Simulator!");

        for (int i = 0; i < gamesCount; i++) {
            System.out.println("==================================NEW GAME==================================");
            player1Score = 0;
            player2Score = 0;
            while (player1Score < scoreToWin && player2Score < scoreToWin) {
//                System.out.println("|||||||||||||||||||PLAYER1 SCORE: " + player1Score + "|||||||||||||||||||");
                player1Score += PlayerStrategies.randomStrategyPlayer(player1);
                if (player1Score >= scoreToWin) {
                    break;
                }
//                System.out.println("|||||||||||||||||||PLAYER2 SCORE: " + player2Score + "|||||||||||||||||||");
                player2Score += PlayerStrategies.randomStrategyPlayer(player2);
            }

//            System.out.println("!!!!!!!!!!!!!No New Turn - Game Has Finished!!!!!!!!!!!!!");
            if(player1Score == player2Score){
                System.out.println("DRAW");
            }
            else if (player1Score >= scoreToWin) {
                player1Wins++;
                System.out.println("Player 1 Wins");
            } else {
                player2Wins++;
                System.out.println("Player 2 Wins");
            }
            System.out.println("Player 1 Final Score: " + player1Score);
            System.out.println("Player 2 Final Score: " + player2Score);
        }

        double player1WinPercent = (player1Wins * 1.0 / gamesCount) * 100.0;
        double player2WinPercent = (player2Wins * 1.0 / gamesCount) * 100.0;

//        System.out.println("Player 1 Wins: " + player1Wins);
//        System.out.println("Player 2 Wins: " + player2Wins);
        System.out.println("\n||||||||||||||||||WIN PERCENTAGES||||||||||||||||||");
        System.out.println("Player 1 Win Percentage: " + player1WinPercent + "%");
        System.out.println("Player 2 Win Percentage: " + player2WinPercent + "%");

        System.out.println("That's all folks!");
    }
}

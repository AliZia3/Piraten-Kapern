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

    public void play(String player1, String player2, int gamesCount) {
        System.out.println("Welcome to Piraten Karpen Simulator!");

        for (int i = 0; i < gamesCount; i++) {
            player1Score = 0;
            player2Score = 0;
            while (player1Score <= scoreToWin && player2Score <= scoreToWin) {
                player1Score += PlayerStrategies.randomStrategy(player1);
                System.out.println("===============================================PLAYER1 SCORE: " + player1Score);
                player2Score += PlayerStrategies.randomStrategy(player2);
                System.out.println("===============================================PLAYER2 SCORE: " + player2Score);
            }

            if (player1Score >= scoreToWin) {
                player1Wins++;
            } else {
                player2Wins++;
            }
        }

        double player1WinPercent = (player1Wins * 1.0 / gamesCount * 1.0) * 100.0;
        double player2WinPercent = (player2Wins * 1.0 / gamesCount * 1.0) * 100.0;

        System.out.println("Player 1 Wins: " + player1Wins);
        System.out.println("Player 2 Wins: " + player2Wins);
        System.out.println("Player 1 Win Percentage: " + player1WinPercent + "%");
        System.out.println("Player 2 Win Percentage: " + player2WinPercent + "%");

        System.out.println("That's all folks!");
    }
}

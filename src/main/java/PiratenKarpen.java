import pk.Turns;

public class PiratenKarpen {

    public static void main(String[] args) {
        // Initial Vars
        int gamesCount = 42;
        int player1Wins = 0;
        int player2Wins = 0;

        String player1 = "Player 1";
        String player2 = "Player 2";

        System.out.println("Welcome to Piraten Karpen Simulator!");

        for (int i = 0; i < gamesCount; i++) {
            int player1Score = 0;
            int player2Score = 0;

            while (player1Score <= 6000 && player2Score <= 6000) {
                player1Score += Turns.turn(player1);
                player2Score += Turns.turn(player2);
            }

            if (player1Score >= 6000) {
                player1Wins++;
            } else {
                player2Wins++;
            }

        }


        System.out.println("That's all folks!");
    }

}

import pk.Game;
import pk.ManageLogs;

public class PiratenKarpen {
    public static void main(String[] args) {

        Game game = new Game();
        // If no command line arguments given
        if (args.length == 0) {
            game.play(42, "random", "combo");
            return;
        }
        // If 4 command line arguments (run with user inputted command line argument)
        if (args.length == 4) {
            ManageLogs.loggerCondition(args[3]);
        }
        game.play(Integer.parseInt(args[0]), args[1], args[2]);
    }
}

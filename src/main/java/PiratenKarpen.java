import pk.Game;

public class PiratenKarpen {
    public static void main(String[] args) {

        Game game = new Game();
        // If no command line arguments given
        if (args.length == 0) {
            game.play(42, true, "random", "combo");
        }
        // Run without trace mode and with strategies ('trace' not given as command line argument)
        else if (args.length < 3) {
            game.play(42,false, args[0], args[1]);
        }
        // Run with trace mode and with strategies ('trace' given as command line argument)
        else {
            for (String arg:args) {
                game.play(42, arg.contains("trace"), args[1], args[2]);
                break;
            }
        }

    }
}

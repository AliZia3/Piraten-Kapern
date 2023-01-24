import pk.Game;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

public class PiratenKarpen {
//    private static final Logger logger = LogManager.getLogger(PiratenKarpen.class);
    public static void main(String[] args) {

        Game game = new Game();
        game.play("player 1", "player 2", 42);

    }
}

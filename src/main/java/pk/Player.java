package pk;

import java.util.Objects;

public class Player {
    private int score;
    private String strategy;

    // Constructor
    public Player(String playerStrategy) {
        this.score = 0;
        if (Objects.equals(playerStrategy, "random")) {
            this.strategy = "random";
        } else {
            this.strategy = "combo";
        }
    }

    public int turn(Cards cardDrawn, String currPlayer) {
        if(cardDrawn.equals(Cards.NOP)){
            if (Objects.equals(strategy, "combo")) {
                score = PlayerStrategies.comboStrategy(currPlayer);
            } else {
                score = PlayerStrategies.randomStrategy(currPlayer);
            }
            return score;
        }

        else {
            if (cardDrawn.equals(Cards.SEABATTLE300)) {
                return PlayerStrategies.seaBattleStrategy(2, 300, currPlayer);
            } else if (cardDrawn.equals(Cards.SEABATTLE500)){
                return PlayerStrategies.seaBattleStrategy(3, 500, currPlayer);
            } else {
                return PlayerStrategies.seaBattleStrategy(4, 1000, currPlayer);
            }
        }
    }
}

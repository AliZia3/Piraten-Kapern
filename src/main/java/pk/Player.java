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

    public int turn() {
        if (Objects.equals(strategy, "combo")) {
            score = PlayerStrategies.comboStrategyPlayer();
        } else {
            score = PlayerStrategies.randomStrategyPlayer();
        }
        return score;
    }
}

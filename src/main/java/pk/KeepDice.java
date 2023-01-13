package pk;
import java.util.Random;

public class KeepDice {
    public  int diceInHand(){
        Random dice = new Random();
        return dice.nextInt(7)+2;
    }
}

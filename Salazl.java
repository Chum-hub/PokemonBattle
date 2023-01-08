import java.util.Random;

public class Salazl extends Salandit {
    protected void fireClaws(Pokemon pokemon) {
        Random rn = new Random();
        if (isEnoughAtkPts(25)) pokemon.dealDmg(rn.nextInt(50));
    }
}

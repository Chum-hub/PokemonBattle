import java.util.Random;

public class Salandit extends Fire {
    protected void simpleAttack(Pokemon pokemon) {
        Random rn = new Random();
        if (isEnoughAtkPts(10)) pokemon.dealDmg(rn.nextInt(25));
    }
}

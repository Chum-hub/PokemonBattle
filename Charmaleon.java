import java.util.Random;

public class Charmaleon extends Charmander {
    Random rn = new Random();

    protected void tailOfFire(Pokemon pokemon) {
        if (isEnoughAtkPts(40)) pokemon.dealDmg(rn.nextInt(20) + 30);
    }
}

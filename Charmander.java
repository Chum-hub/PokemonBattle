import java.util.Random;

public class Charmander extends Fire {
    Random rn = new Random();

    protected void scratch(Pokemon pokemon) {
        if (isEnoughAtkPts(15)) pokemon.dealDmg(rn.nextInt(5) + 25);
    }
}

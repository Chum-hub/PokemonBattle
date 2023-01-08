import java.util.Random;

public class Charizard extends Charmaleon {

    protected void fireBlow(Pokemon pokemon) {
        if (isEnoughAtkPts(50)) pokemon.dealDmg(50);
    }
}

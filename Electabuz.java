import java.util.Random;

public class Electabuz extends Electric{
    public void zapAttack(Pokemon pokemon) {
        Random rn = new Random();
        if (isEnoughAtkPts(60)) pokemon.dealDmg(rn.nextInt(5) + 40);
    }
}
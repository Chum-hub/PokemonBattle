import java.util.Random;

public class Electivire extends Electric{
    public void thunderStrike(Pokemon pokemon) {
        Random rn = new Random();
        if (isEnoughAtkPts(80)) pokemon.dealDmg(rn.nextInt(70) + 50);
    }
}
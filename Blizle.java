import java.util.Random;

public class Blizle extends Electric{
    public void flop(Pokemon pokemon) {
        Random rn = new Random();
        if (isEnoughAtkPts(20)) pokemon.dealDmg(rn.nextInt(5) + 20);
    }
}

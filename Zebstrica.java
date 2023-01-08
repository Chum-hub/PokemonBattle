import java.util.Random;

public class Zebstrica extends Blizle{
    public void zapAttack(Pokemon pokemon) {
        Random rn = new Random();
        if (isEnoughAtkPts(30)) pokemon.dealDmg(rn.nextInt(5) + 30);
    }
}
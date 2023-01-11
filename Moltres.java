import java.util.Random;

public class Moltres extends Fire {


    public void overheat(Pokemon pokemon) {
        Random rn = new Random();
        if (isEnoughAtkPts(30)) pokemon.dealDmg(rn.nextInt(50) + 10);
    }
    public void fireWing(Pokemon pokemon) {
        Random rn = new Random();
        if (isEnoughAtkPts(30)) pokemon.dealDmg(30);
    }
}

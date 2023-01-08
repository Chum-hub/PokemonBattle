import java.util.Random;

public class Raichu extends Pikachu{
    public void electroSurfer(Pokemon pokemon) {
        Random rn = new Random();
        if (isEnoughAtkPts(60)) pokemon.dealDmg(rn.nextInt(100) + 20);
    }
}


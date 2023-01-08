import java.util.Random;

public class Pikachu extends Pichu{
    public void electroBall(Pokemon pokemon) {
        Random rn = new Random();
        if (isEnoughAtkPts(10)) pokemon.dealDmg(rn.nextInt(10) + 30);
    }
}

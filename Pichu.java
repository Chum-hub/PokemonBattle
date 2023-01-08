public class Pichu extends Electric{
    public void fastAttack(Pokemon pokemon) {
        if (isEnoughAtkPts(5)) pokemon.dealDmg(10);
    }
}

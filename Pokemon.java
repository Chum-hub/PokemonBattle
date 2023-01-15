import java.util.Random;
public abstract class Pokemon {
    private boolean isDead = false;
    private boolean isRage = false;
    private String name;
    private String firstLvlName;
    private int maxHp;
    private int maxAttackPoints;
    private int currentHp;
    private double currentAttackPoints;
    private int maxLvl;
    private int currentLvl = 1;
    private Abilities[] abilities;
    private Pokemons[] pokemons;
    public void setPokemons(Pokemons[] pokemons) {
        this.pokemons = pokemons;
    }
    public void setAbilities(Abilities[] abilities) {
        this.abilities = abilities;
    }
    public Abilities[] getAbilities() {
        return abilities;
    }
    public String toString() {
        return "Pokemon: " + name + " " +
                "HP - (" + currentHp + "/" + maxHp + ")" + " " +
                "Mana - (" + currentAttackPoints + "/" + maxAttackPoints + ")";
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFirstLvlName() {
        return firstLvlName;
    }
    public void setFirstLvlName(String firstLvlName) {
        this.firstLvlName = firstLvlName;
    }
    public boolean isDead() {
        return isDead;
    }
    public void checkDead() {
        if (this.currentHp <= 0) this.isDead = true;
    }
    public void setRage(boolean rage) {
        isRage = rage;
    }
    public void setMaxLvl(int maxLvl) {
        this.maxLvl = maxLvl;
    }
    public void setCurrentLvl(int currentLvl) {
        this.currentLvl = currentLvl;
    }
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
    public void setMaxAttackPoints(int maxAttackPoints) {
        this.maxAttackPoints = maxAttackPoints;
    }
    public String getName() {
        return name;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public int getMaxAttackPoints() {
        return maxAttackPoints;
    }
    public void setCurrentAttackPoints(double currentAttackPoints) {
        this.currentAttackPoints = currentAttackPoints;
    }
    public int getMaxLvl() {
        return maxLvl;
    }
    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }
    public int getCurrentHp() {
        return currentHp;
    }
    public double getCurrentAttackPoints() {
        return currentAttackPoints;
    }
    public int getCurrentLvl() {
        return currentLvl;
    }
    public void kick(Pokemon pokemon) {
        pokemon.dealDmg(100);
    }
    public void dealDmg(int dmg) {
        this.currentHp -= dmg;
        System.out.println("Was dealt " + dmg + " damage");
    }
    public boolean isEnoughAtkPts(int costAttackPts) {
        return this.currentAttackPoints >= costAttackPts;
    }
    public void skill(Player enemy, int costAttackPts, int minDmg, int maxDmg, int dmg) {
        Random rn = new Random();
        if (this.isRage) {
            costAttackPts *= 3;
            minDmg *= 3;
            maxDmg *= 3;
            dmg *= 3;
        }
        if (this instanceof Electric) {
            minDmg *= ((Electric) this).getCurrentCharge();
            maxDmg *= ((Electric) this).getCurrentCharge();
            dmg *= ((Electric) this).getCurrentCharge();
        }
        if (isEnoughAtkPts(costAttackPts) && dmg == 0) {
            this.currentAttackPoints -= costAttackPts;
            enemy.getPokemon().dealDmg(rn.nextInt(maxDmg - minDmg) + minDmg);
        } else if (isEnoughAtkPts(costAttackPts) && dmg != 0) {
            this.currentAttackPoints -= costAttackPts;
            enemy.getPokemon().dealDmg(dmg);
        }
        if (this instanceof Fire) ((Fire) this).selfDamage();
        if (this instanceof Electric) ((Electric) this).chargePerTurn();
        this.setRage(false);
        getManaPerTurn();
        getHpPerTurn();
    }
    public void getManaPerTurn() {
        if (isManaFullToAdd(5)) {
            this.setCurrentAttackPoints(this.getCurrentAttackPoints() + 5);
        } else {
            this.setCurrentAttackPoints(this.getMaxAttackPoints());
        }
        System.out.println("+5 mana");
    }
    public void getHpPerTurn() {
        if (isHpFullToAdd(5)){
            this.setCurrentHp(this.getCurrentHp() + 5);
        } else {
            this.setCurrentHp(this.getMaxHp());
        }
        System.out.println("+5 Hp");
    }
    public void evolution() {
        for (Pokemons pokemon : pokemons) {
            if (pokemon.firstLvlName.equals(this.getFirstLvlName()) && pokemon.lvl == this.getCurrentLvl() + 1) {
                this.setCurrentLvl(pokemon.lvl);
                this.setName(pokemon.name);
                this.setMaxHp(pokemon.hp);
                this.setCurrentHp(this.getCurrentLvl() == 2 ? this.getCurrentHp() - 20 : this.getCurrentHp() - 30);
                this.setMaxAttackPoints(pokemon.mana);
                this.setCurrentAttackPoints(this.getCurrentLvl() == 2 ? this.getCurrentAttackPoints() - 25 : this.getCurrentAttackPoints() - 40);
                System.out.println("Now your pokemon have Evolutionized to " + this.getName());
                break;
            }
        }
    }
    public boolean isManaFullToAdd(int mana){
        return this.getCurrentAttackPoints() + mana > this.getCurrentAttackPoints();
    }
    public boolean isManaFullToAdd(double mana){
        return this.getCurrentAttackPoints() + mana > this.getCurrentAttackPoints();
    }
    public boolean isHpFullToAdd(int hp){
        return this.getCurrentHp() + hp > this.getCurrentHp();
    }

}


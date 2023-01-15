public class Electric extends Pokemon {
    private final double maxCharge = 1.30;
    private boolean isUltimateReady = true;
    private double currentCharge = 1;
    private Pokemons[] pokemons =
            {
                    new Pokemons("Pichu", "Pichu", 3, 1, 30, 40),
                    new Pokemons("pikachu", "Pichu", 3, 2, 40, 50),
                    new Pokemons("raichu", "Pichu", 3, 3, 80, 160),

                    new Pokemons("Blizle", "Blizle", 2, 1, 35, 90),
                    new Pokemons("Zebstrica", "Blizle", 2, 2, 50, 100),

                    new Pokemons("Electabuz", "Electabuz", 2, 1, 100, 30),
                    new Pokemons("Electivire", "Electabuz", 2, 2, 120, 35),
            };
    private Abilities[] abilities =
            {
                    new Abilities("Fast Attack", "Pichu", 1, 5, 0, 0, 10),
                    new Abilities("Electroball", "Pichu", 2, 10, 30, 40, 0),
                    new Abilities("Electro Surfer", "Pichu", 3, 60, 20, 120, 0),

                    new Abilities("Flop", "Blizle", 1, 20, 20, 25, 0),
                    new Abilities("Zap", "Blizle", 2, 30, 30, 35, 0),

                    new Abilities("Lightning", "Electabuz", 1, 60, 40, 50, 0),
                    new Abilities("Thunder Strike", "Electabuz", 1, 80, 50, 120, 0),
            };
    public void chargePerTurn() {
        this.currentCharge = (this.currentCharge <= this.maxCharge - 0.05) ? this.currentCharge + 0.05 : maxCharge;
    }
    public double getCurrentCharge() {
        return currentCharge;
    }

    public boolean isUltimateReady() {
        return isUltimateReady;
    }

    public void setUltimateReady(boolean ultimateReady) {
        isUltimateReady = ultimateReady;
    }

    public Electric(String name) {
        Pokemons pokemon = null;
        for (Pokemons pokemons : pokemons) {
            if (pokemons.name.equals(name)) {
                pokemon = pokemons;
            }
        }
        if (pokemon != null) {
            this.setAbilities(abilities);
            this.setName(pokemon.name);
            this.setFirstLvlName(pokemon.firstLvlName);
            this.setCurrentHp(pokemon.hp);
            this.setMaxHp(pokemon.hp);
            this.setCurrentAttackPoints(pokemon.mana * 0.75);
            this.setMaxAttackPoints(pokemon.mana);
            this.setMaxLvl(pokemon.maxLvl);
        }
    }


}

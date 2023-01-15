import java.util.Random;

public class Fire extends Pokemon {
    private Pokemons[] pokemons =
            {
                    new Pokemons("Charmander", "Charmander", 3, 1, 40, 80),
                    new Pokemons("Charmaleon", "Charmander", 3, 2, 60, 90),
                    new Pokemons("Charizard", "Charmander", 3, 3, 80, 130),

                    new Pokemons("Salandit", "Salandit", 2, 1, 60, 100),
                    new Pokemons("Salazl", "Salandit", 2, 2, 80, 160),

                    new Pokemons("Moltres", "Moltres", 1, 1, 60, 120),
            };
    private Abilities[] abilities =
            {
                    new Abilities("Scratch", "Charmander", 1, 15, 25, 30, 0),
                    new Abilities("Tail Of Fire", "Charmander", 2, 40, 30, 50, 0),
                    new Abilities("Fire Explosion", "Charmander", 3, 50, 0, 0, 50),

                    new Abilities("Fireball", "Salandit", 1, 10, 0, 25, 0),
                    new Abilities("Fire Claws", "Salandit", 2, 25, 0, 50, 0),

                    new Abilities("Overheat", "Moltres", 1, 30, 10, 60, 0),
                    new Abilities("Fire Wing", "Moltres", 1, 30, 0, 0, 30),
            };

    public void selfDamage() {
        int dmg;
        Random rn = new Random();
        dmg = rn.nextInt((7) + 3);
        if (chanceToSelfDmg()) {
            this.setCurrentHp(this.getCurrentHp() - dmg);
            System.out.println("SelfDamage: " + dmg);
        }
    }

    public boolean chanceToSelfDmg() {
        int chance;
        Random rn = new Random();
        chance = rn.nextInt(4);
        return chance == 0;
    }

    public Fire(String name) {
        Pokemons pokemon = null;
        for (Pokemons pokemons : pokemons) {
            if (pokemons.name.equals(name)) {
                pokemon = pokemons;
            }
        }
        if (pokemon != null) {
            this.setPokemons(pokemons);
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

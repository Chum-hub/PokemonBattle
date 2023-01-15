import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private Pokemon pokemon;

    public String toString() {
        return "Player: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void choosePokemonType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the pokemon type: 1 - Charmander, 2 - Salandit, 3 - Moltres, 4 - Pichu," + '\'' +
                "5 - Blizle, 6 - Electabuz");
        switch (sc.nextInt()) {
            case 1 -> this.pokemon = new Fire("Charmander");
            case 2 -> this.pokemon = new Fire("Salandit");
            case 3 -> this.pokemon = new Fire("Moltres");
            case 4 -> this.pokemon = new Electric("Pichu");
            case 5 -> this.pokemon = new Electric("Blizle");
            case 6 -> this.pokemon = new Electric("Electabuz");
        }
    }

    public void turn(Player player) {
        Scanner sc = new Scanner(System.in);
        System.out.println(this);
        System.out.println("Choose the action: 1 - Use any abilities, 2 - Skip, 3 - EVO, 4 - Ultimate");
        switch (sc.nextInt()) {
            case 1 -> {
                System.out.println(this.pokemon.toString());
                chooseSkill(player);
            }
            case 2 -> skip();
            case 3 -> {
                final int costHpLvl1 = 20;
                final int costHpLvl2 = 30;
                final int costManaLvl1 = 25;
                final int costManaLvl2 = 40;
                if (this.pokemon.getCurrentLvl() < this.pokemon.getMaxLvl()) {
                    if (this.pokemon.getCurrentLvl() == 1 || this.pokemon.getCurrentHp() > costHpLvl1 || this.pokemon.isEnoughAtkPts(costManaLvl1)) {
                        this.pokemon.evolution();
                    } else if (this.pokemon.getCurrentLvl() == 2 || this.pokemon.getCurrentHp() > costHpLvl2 || this.pokemon.isEnoughAtkPts(costManaLvl2)) {
                        this.pokemon.evolution();
                    } else {
                        System.out.println("Not enough Hp or Mana!");
                        turn(player);
                    }
                } else if (this.pokemon.getCurrentLvl() == this.pokemon.getMaxLvl()) {
                    System.out.println("Your pokemon not allow to evolution! You have reached the Max Lvl.");
                    turn(player);
                }
            }
            case 4 -> ultimate(player);
        }
    }
    public void ultimate(Player player) {
        if (this.pokemon instanceof Electric) {
            if (((Electric) this.pokemon).isUltimateReady()) {
                this.pokemon.setCurrentHp(this.pokemon.getMaxHp());
                this.pokemon.setCurrentAttackPoints(this.pokemon.getMaxAttackPoints());
                ((Electric) this.pokemon).setUltimateReady(false);
            } else {
                System.out.println("Your Ultimate more is not allow to use!");
            }
        } else {
            randomSkill(player);
            randomSkill(player);
            this.pokemon.setCurrentAttackPoints(0);
            this.pokemon.setCurrentHp((this.pokemon.getCurrentHp() / 2));
        }
    }

    public void randomSkill(Player player){
        Random rn = new Random();
        int choose;
        choose = rn.nextInt(3) + 1;
        for (int i = 0; i < this.pokemon.getAbilities().length; i++) {
            if (this.pokemon.getAbilities()[i].getSearchId() == choose) {
                this.pokemon.skill(player, this.skillCost(choose), skillMinDmg(choose), skillMaxDmg(choose), skillDmg(choose));
                break;
            } else {
                choose = rn.nextInt(3) + 1;
            }
        }
    }

    public void skip() {
        Random rn = new Random();
        int a;
        double b;
        int chance = rn.nextInt(3);
        if (chance == 0) {
            a = this.pokemon.getCurrentHp() + rn.nextInt(25) + 5;
            if (a > this.pokemon.getMaxHp()) {
                this.pokemon.setCurrentHp(this.pokemon.getMaxHp());
            } else {
                this.pokemon.setCurrentHp(a);
            }
            System.out.println("Now your Hp: " + this.pokemon.getCurrentHp());
        } else if (chance == 1) {
            b = this.pokemon.getCurrentAttackPoints() + rn.nextInt(25) + 5;
            if (b > this.pokemon.getCurrentAttackPoints()) {
                this.pokemon.setCurrentAttackPoints(this.pokemon.getMaxHp());
            } else {
                this.pokemon.setCurrentAttackPoints(b);
            }
            System.out.println("Now your Mana: " + this.pokemon.getCurrentAttackPoints());
        } else {
            this.pokemon.setRage(true);
            System.out.println("You got a Rage mode! (Your next turn have a 3X damage!)");
        }
    }

    public void chooseSkill(Player player) {
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println("Choose skill to use. 0 - return to previous menu");
            showSkillsToPlayer();
            choose = sc.nextInt();
            if (choose == 1) {
                this.pokemon.kick(player.pokemon);
            } else if (choose == 0) {
                turn(player);
            } else {
                if (!isSkillExist(choose)) {
                    System.out.println("This skill is not available!");
                    turn(player);
                    break;
                }
                if (this.pokemon.getCurrentAttackPoints() < skillCost(choose)) {
                    System.out.println("Not enough Mana!");
                    turn(player);
                    break;
                } else {
                    this.pokemon.skill(player, skillCost(choose), skillMinDmg(choose), skillMaxDmg(choose), skillDmg(choose));
                }
            }
        } while (choose < 1 || choose > 4);
    }

    public boolean isSkillExist(int searchId) {
        for (int i = 0; i < this.pokemon.getAbilities().length; i++) {
            if (this.pokemon.getAbilities()[i].getSearchId() == searchId) return true;
        }
        return false;
    }

    public void showSkillsToPlayer() {
        System.out.println("Skills allowed to your pokemon: ");
        System.out.println("1) Kick (Cost: 0, Dmg: 2)");
        int counter = 2;
        for (int i = 0; i < this.pokemon.getAbilities().length; i++) {
            if (this.pokemon.getFirstLvlName().equals(this.pokemon.getAbilities()[i].getAbilityHolder()) && this.pokemon.getCurrentLvl() >= this.pokemon.getAbilities()[i].getUseLvl()) {
                System.out.println(counter + ") " + this.pokemon.getAbilities()[i].getAbilityName() + " (" + this.pokemon.getAbilities()[i].toString() + ")");
                this.pokemon.getAbilities()[i].setSearchId(counter);
                counter++;
            }
        }
    }

    public int skillCost(int id) {
        int cost = 0;
        for (Abilities ab : this.pokemon.getAbilities()) {
            if (ab.getSearchId() == id) cost = ab.getAbilityCost();
        }
        return cost;
    }

    public int skillMinDmg(int id) {
        int a = 0;
        for (Abilities ab : this.pokemon.getAbilities()) {
            if (ab.getSearchId() == id) a = ab.getAbilityMinDmg();
        }
        if (this.pokemon instanceof Electric) return (int) (a * ((Electric) this.pokemon).getCurrentCharge());
        return a;
    }

    public int skillMaxDmg(int id) {
        int a = 0;
        for (Abilities ab : this.pokemon.getAbilities()) {
            if (ab.getSearchId() == id) a = ab.getAbilityMaxDmg();
        }
        if (this.pokemon instanceof Electric) return (int) (a * ((Electric) this.pokemon).getCurrentCharge());
        return a;
    }

    public int skillDmg(int id) {
        int a = 0;
        for (Abilities ab : this.pokemon.getAbilities()) {
            if (ab.getSearchId() == id) a = ab.getAbilityDmg();
        }
        if (this.pokemon instanceof Electric) return (int) (a * ((Electric) this.pokemon).getCurrentCharge());
        return a;
    }
}

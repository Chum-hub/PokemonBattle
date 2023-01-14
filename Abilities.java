public class Abilities {
    private String abilityName;
    private String abilityHolder;
    private int searchId;
    private int useLvl;
    private int abilityCost;
    private int abilityMinDmg;
    private int abilityMaxDmg;
    private int abilityDmg;
    public int getSearchId() {
        return searchId;
    }
    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }
    public String getAbilityName() {
        return abilityName;
    }
    public String getAbilityHolder() {
        return abilityHolder;
    }
    public int getUseLvl() {
        return useLvl;
    }
    public int getAbilityCost() {
        return abilityCost;
    }
    public String toString() {
        return "Cost: " + abilityCost + ", " +
                "MinDmg: " + abilityMinDmg + ", " +
                "MaxDmg: " + abilityMaxDmg + ", " +
                "Dmg: " + abilityDmg;
    }
    public int getAbilityMinDmg() {
        return abilityMinDmg;
    }
    public int getAbilityMaxDmg() {
        return abilityMaxDmg;
    }
    public int getAbilityDmg() {
        return abilityDmg;
    }
    public Abilities(String abilityName, String abilityHolder, int useLvl, int abilityCost, int abilityMinDmg, int abilityMaxDmg, int dmg) {
        this.abilityName = abilityName;
        this.abilityHolder = abilityHolder;
        this.useLvl = useLvl;
        this.abilityCost = abilityCost;
        this.abilityMinDmg = abilityMinDmg;
        this.abilityMaxDmg = abilityMaxDmg;
        this.abilityDmg = dmg;
    }
}

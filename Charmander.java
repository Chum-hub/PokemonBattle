public class Charmander extends Fire {
    public final String CHARMANDER_NAME = "Charmander";
    public final int CHARMANDER_MAX_LVL = 3;
    public final int CHARMANDER_MAX_HP = 90;
    public final int CHARMANDER_MAX_POINTS = 90;
    public final String SCRATCH_NAME = "Scratch";
    public final int SCRATCH_COST = 15;
    public final int SCRATCH_MIN_DAMAGE = 25;
    public final int SCRATCH_MAX_DAMAGE = 30;
    ////////////////////////////////////
    public final String CHARMALEON_NAME = "Charmaleon";
    public final int CHARMALEON_MAX_HP = 90;
    public final String TAIL_OF_FIRE_NAME = "Tail of fire";
    public final int TAIL_OF_FIRE_COST = 40;
    public final int TAIL_OF_FIRE_MIN_DAMAGE = 30;
    public final int TAIL_OF_FIRE_MAX_DAMAGE = 50;
    ///////////////////////////////////
    public final String CHARIZARD_NAME = "Charizard";
    public final int CHARIZARD_MAX_HP = 90;
    public final String FIRE_BLOW_NAME = "Fire blow";
    public final int FIRE_BLOW_COST = 50;
    public final int FIRE_BLOW_DAMAGE = 50;

    public String getCHARMANDER_NAME() {
        return CHARMANDER_NAME;
    }

    public int getCHARMANDER_MAX_LVL() {
        return CHARMANDER_MAX_LVL;
    }

    public int getCHARMANDER_MAX_HP() {
        return CHARMANDER_MAX_HP;
    }

    public int getCHARMANDER_MAX_POINTS() {
        return CHARMANDER_MAX_POINTS;
    }

    public String getSCRATCH_NAME() {
        return SCRATCH_NAME;
    }

    public int getSCRATCH_COST() {
        return SCRATCH_COST;
    }

    public int getSCRATCH_MIN_DAMAGE() {
        return SCRATCH_MIN_DAMAGE;
    }

    public int getSCRATCH_MAX_DAMAGE() {
        return SCRATCH_MAX_DAMAGE;
    }

    public String getCHARMALEON_NAME() {
        return CHARMALEON_NAME;
    }

    public int getCHARMALEON_MAX_HP() {
        return CHARMALEON_MAX_HP;
    }

    public String getTAIL_OF_FIRE_NAME() {
        return TAIL_OF_FIRE_NAME;
    }

    public int getTAIL_OF_FIRE_COST() {
        return TAIL_OF_FIRE_COST;
    }

    public int getTAIL_OF_FIRE_MIN_DAMAGE() {
        return TAIL_OF_FIRE_MIN_DAMAGE;
    }

    public int getTAIL_OF_FIRE_MAX_DAMAGE() {
        return TAIL_OF_FIRE_MAX_DAMAGE;
    }

    public String getCHARIZARD_NAME() {
        return CHARIZARD_NAME;
    }

    public int getCHARIZARD_MAX_HP() {
        return CHARIZARD_MAX_HP;
    }

    public String getFIRE_BLOW_NAME() {
        return FIRE_BLOW_NAME;
    }

    public int getFIRE_BLOW_COST() {
        return FIRE_BLOW_COST;
    }

    public int getFIRE_BLOW_DAMAGE() {
        return FIRE_BLOW_DAMAGE;
    }

    public Charmander() {
        this.setName(CHARMANDER_NAME);
        this.setMaxHp(CHARMANDER_MAX_HP);
        this.setMaxAttackPoints(CHARMANDER_MAX_POINTS);
        this.setMaxLvl(CHARMANDER_MAX_LVL);
        this.setMaxDmg1(SCRATCH_MAX_DAMAGE);
        this.setMinDmg1(SCRATCH_MIN_DAMAGE);
        this.setCost1(SCRATCH_COST);
        this.setSkillName1(SCRATCH_NAME);
    }
}

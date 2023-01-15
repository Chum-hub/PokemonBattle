import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player pl1 = new Player();
        Player pl2 = new Player();
        Scanner sc = new Scanner(System.in);
        display();
        pl1.setName(sc.nextLine());
        pl1.choosePokemonType();
        display();
        pl2.setName(sc.nextLine());
        pl2.choosePokemonType();
        System.out.println(pl1.toString() + " and your " + pl1.getPokemon().toString());
        System.out.println(pl2.toString() + " and your " + pl2.getPokemon().toString());

        while (!pl1.getPokemon().isDead() && !pl2.getPokemon().isDead()) {
            if (!pl1.getPokemon().isDead() && !pl2.getPokemon().isDead()) {
                pl1.turn(pl2);
                pl2.getPokemon().checkDead();
                pl1.getPokemon().checkDead();
            }
            if (!pl1.getPokemon().isDead() && !pl2.getPokemon().isDead()) {
                pl2.turn(pl1);
                pl1.getPokemon().checkDead();
                pl2.getPokemon().checkDead();
            }
        }
        System.out.println(displayWinner(pl1, pl2));
    }

    public static void display() {
        System.out.println("Enter player name:");
    }

    public static String displayWinner(Player pl1, Player pl2) {
        return pl1.getPokemon().isDead() ? pl2.getName() + " is winner!" : pl1.getName() + " is winner!";
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player pl1 = new Player();
        Player pl2 = new Player();
        Scanner sc = new Scanner(System.in);

        display();
        pl1.setName(sc.nextLine());
        display();
        pl2.setName(sc.nextLine());

        pl1.choosePokemonType();
        pl2.choosePokemonType();
        do {
            pl1.turn(pl2);
            pl2.turn(pl1);
        } while (!pl1.getPokemon().isDead() || !pl2.getPokemon().isDead());

    }

    public static void display() {
        System.out.println("Enter your name");
    }
}

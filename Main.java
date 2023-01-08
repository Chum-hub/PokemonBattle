import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player pl1;
        Player pl2;
        Scanner sc = new Scanner(System.in);
        display();
        pl1 = chooseName(sc.nextLine());
        display();
        pl2 = chooseName(sc.nextLine());
        pl1.choosePokemonType();
        pl2.choosePokemonType();
        pl1.createPokemon();
        pl2.createPokemon();

    }

    public static void display() {
        System.out.println("Enter your name");
    }

    public static Player chooseName(String name) {
        Player player = new Player();
        player.setName(name);
        return player;
    }
}

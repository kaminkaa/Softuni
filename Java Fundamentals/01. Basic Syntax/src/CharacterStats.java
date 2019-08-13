import java.util.Scanner;

/**
 * Created by Cammi on 21/09/2017.
 */
public class CharacterStats {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        int currenthealth = Integer.parseInt(console.nextLine());
        int maxhealth = Integer.parseInt(console.nextLine());
        int currentenergy = Integer.parseInt(console.nextLine());
        int maxenergy = Integer.parseInt(console.nextLine());

        System.out.println("Name: " + name);
        System.out.printf("Health: |");
        for(int i=1; i<=currenthealth; i++){
            System.out.printf("|");
        }
        for(int i=0; i<maxhealth-currenthealth; i++){
            System.out.printf(".");
        }
        System.out.printf("|");
        System.out.println();
        System.out.printf("Energy: |");
        for(int i=1; i<=currentenergy; i++){
            System.out.printf("|");
        }
        for(int i=0; i<maxenergy-currentenergy; i++){
            System.out.printf(".");
        }
        System.out.printf("|");
    }
}

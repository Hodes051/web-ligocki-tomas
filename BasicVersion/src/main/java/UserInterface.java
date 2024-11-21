import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Evidence evidence;

    public UserInterface(Scanner scanner, Evidence evidence) {
        this.scanner = scanner;
        this.evidence = evidence;
    }

    public void getInterface() {
        int akce = 0;
        while (akce != 4) {
            System.out.println("-----------------------------\n" +
                    "Evidence pojištěných \n" +
                    "-----------------------------\n" +
                    "\nVyberte si akci: \n" +
                    "1 - Přidat nového pojištěného \n" +
                    "2 - Vypsat všechny pojištěné \n" +
                    "3 - Vyhledat pojištěného \n" +
                    "4 - Konec");
            try {
                akce = Integer.parseInt(scanner.nextLine());
                if (akce < 1 || akce > 4) {
                    System.out.println("Neplatná hodnota, zadejte 1-4:");
                    continue;
                }
                System.out.println();
                switch (akce) {
                    case 1:
                        evidence.addToEvidence();
                        System.out.println("\nData byla uložena. Pokračujte libovolnou klávesou...");
                        scanner.nextLine();
                        break;
                    case 2:
                        evidence.showEntireEvidence();
                        System.out.println("\nPokračujte libovolnou klávesou...");
                        scanner.nextLine();
                        break;
                    case 3:
                        evidence.showSingleEvidence();
                        System.out.println("\nPokračujte libovolnou klávesou...");
                        scanner.nextLine();
                        break;
                    case 4:
                        System.out.println("Program ukončen");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Neplatný formát, zadejte číslici 1-4:");
            }
        }
        scanner.close();
    }
}




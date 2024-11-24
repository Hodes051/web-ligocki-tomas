package insuranceEvidence;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private EvidenceControl evidenceControl;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.evidenceControl = new EvidenceControl(scanner);
    }

    public void getInterface() {
        int action = 0;
        while (action != 4) {
            System.out.println("-----------------------------\n" +
                    "Evidence pojištěných \n" +
                    "-----------------------------\n" +
                    "\nVyberte si akci pomocí 1-4: \n" +
                    "1 - Přidat nového pojištěného \n" +
                    "2 - Vypsat všechny pojištěné \n" +
                    "3 - Vyhledat pojištěného \n" +
                    "4 - Konec");
            try {
                action = Integer.parseInt(scanner.nextLine());
                if (action < 1 || action > 4) {
                    System.out.println("Neplatná hodnota, zadejte 1-4:");
                    continue;
                }
                System.out.println();
                switch (action) {
                    case 1:
                        evidenceControl.addToEvidence();
                        System.out.println("\nData byla uložena. Pokračujte libovolnou klávesou...");
                        scanner.nextLine();
                        break;
                    case 2:
                        evidenceControl.showEntireEvidence();
                        System.out.println("\nPokračujte libovolnou klávesou...");
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("Zadejte jméno pojištěného:");
                        String name = scanner.nextLine().trim();
                        System.out.println("Zadejte příjmení:");
                        String surname = scanner.nextLine().trim();
                        boolean found = evidenceControl.showSingleEvidence(name, surname);
                        if (!found) {
                            System.out.println("Pojištěnec nenalezen.");
                        }
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

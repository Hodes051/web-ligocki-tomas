package insuranceEvidence;

import java.util.Scanner;

// Třída UserInputValidation slouží k vkládání a ověřování dat zadaných uživatelem.
public class UserInputValidation {
    private Scanner scanner;

    // Konstruktor k inicializaci potřebných závislotí.
    public UserInputValidation(Scanner scanner) {
        this.scanner = scanner;
    }

    // Obecná metoda pro získání textového vstupu a jeho validace.
    public String inputTextWithValidation(String prompt, String errorMessage) {
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(errorMessage);
            } else if (input.matches(".*\\d.*")) {
                System.out.println("Tento vstup nesmí obsahovat číslice.");
            }
        } while (input.isEmpty() || input.matches(".*\\d.*"));
        return input;
    }

    // Metoda k získání jména a jeho validace pomocí obecné textové validace.
    public String nameInput() {
        return inputTextWithValidation("Zadejte jméno pojištěného:", "Jméno je povinné.");
    }

    // Metoda k získání příjmení a jeho validace pomocí obecné textové validace.
    public String surnameInput() {
        return inputTextWithValidation("Zadejte příjmení:", "Příjmení je povinné.");
    }

    // Metoda pro získání a validací telefonního čísla.
    public String phoneInput() {
        String phoneNumber;
        do {
            System.out.println("Zadejte telefonní číslo:");
            phoneNumber = scanner.nextLine().trim();
            if (phoneNumber.isEmpty()) {
                System.out.println("Telefonní číslo je povinné.");
            } else if (!phoneNumber.matches("\\d+")) {
                System.out.println("Telefonni číslo musí obsahovat jen číslice.");
            } else if (phoneNumber.length() < 7 || phoneNumber.length() > 15) {
                System.out.println("Délka telefonního čísla není platná.");
            }
        } while (phoneNumber.isEmpty() || !phoneNumber.matches("\\d+") || (phoneNumber.length() < 7 || phoneNumber.length() > 15));
        return phoneNumber;
    }

    // Metoda pro získání a validaci věku.
    public int ageInput() {
        int age = -1;
        boolean validAge = false;
        while (!validAge) {
            System.out.println("Zadejte věk:");
            String input = scanner.nextLine().trim();
            try {
                age = Integer.parseInt(input);
                if (age >= 0 && age <= 125) {
                    validAge = true;
                } else {
                    System.out.println("Věk musí být v rozmezí 0-125.");
                }
            } catch (NumberFormatException e) {
                if (input.isEmpty()) {
                    System.out.println("Věk je povinný.");
                } else {
                    System.out.println("Neplatný formát, zadejte číslici 0-125.");
                }
            }
        }
        return age;
    }
}




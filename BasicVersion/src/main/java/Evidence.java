import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evidence {
    private List<InsuredData> insureds = new ArrayList<>();
    private Scanner scanner;
    private String name, surname, phoneNumber;
    private int age;

    public Evidence(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addToEvidence() {
        System.out.println("Zadejte jméno pojištěného:");
        System.out.println("Zadejte přijmení pojištěného:");

        do {
            System.out.println("Zadejte příjmení:");
            surname = scanner.nextLine().trim();
            if (surname.isEmpty()) {
                System.out.println("Příjmení je povinné");
            } else if (surname.matches(".*\\d.*")) {
                System.out.println("Příjmení nesmí obsahovat číslice");
            }
        } while (surname.isEmpty() || surname.matches(".*\\d.*"));

        do {
            System.out.println("Zadejte telefonní číslo:");
            phoneNumber = scanner.nextLine().trim();
            if (phoneNumber.isEmpty()) {
                System.out.println("Telefonní číslo je povinné");
            } else if (!phoneNumber.matches("\\d+")) {
                System.out.println("Telefonni číslo musí obsahovat jen číslice");
            } else if (phoneNumber.length() < 7 || phoneNumber.length() > 15) {
                System.out.println("Délka telefonního čísla není platná");
            }
        } while (phoneNumber.isEmpty() || !phoneNumber.matches("\\d+") || (phoneNumber.length() < 7 || phoneNumber.length() > 15));

        boolean validAge = false;
        while (!validAge) {
            System.out.println("Zadejte věk:");
            String input = scanner.nextLine().trim();
            try {
                age = Integer.parseInt(input);
                if (age < 0 || age > 125) {
                    System.out.println("Věk musí být v rozmezí 0-125");
                } else {
                    validAge = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Neplatný formát, zadejte číslici 0-125");
            }
        }
        while (age < 0 || age > 125) ;

        insureds.add(new InsuredData(name, surname, phoneNumber, age));
    }


    public void showEntireEvidence() {
        for (int i = 0; i < insureds.size(); i++) {
            System.out.println(insureds.get(i));
        }
    }

    public void showSingleEvidence() {
        System.out.println("Zadejte jméno pojištěného:");
        String name = scanner.nextLine().trim();
        System.out.println("Zadejte příjmení:");
        String surname = scanner.nextLine().trim();
        System.out.println();

        boolean found = false;
        for (int i = 0; i < insureds.size(); i++) {
            if (insureds.get(i).getName().equalsIgnoreCase(name) && insureds.get(i).getSurname().equalsIgnoreCase(surname)) {
                System.out.println(insureds.get(i));
                found = true;
            }
        } if (!found) {
            System.out.println("Pojištěný nenalezen");
        }
    }
}

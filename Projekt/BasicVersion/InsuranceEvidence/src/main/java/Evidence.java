import java.util.ArrayList;
import java.util.Scanner;

public class Evidence {
    ArrayList<Insured> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String name, surname, phoneNumber;
    int age;

    public void addToEvidence() {
        do {
            System.out.println("Zadejte jméno pojištěného:");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Jméno pojištěného je povinné");
            } else if (name.matches(".*\\d.*")) {
                System.out.println("Jméno nesmí obsahovat číslice");
            }
        } while (name.isEmpty() || name.matches(".*\\d.*"));

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

        list.add(new Insured(name, surname, phoneNumber, age));
    }

    public void showEntireEvidence() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void showSingleEvidence() {
        System.out.println("Zadejte jméno pojištěného:");
        String name = scanner.nextLine().trim();
        System.out.println("Zadejte příjmení:");
        String surname = scanner.nextLine().trim();
        System.out.println();

        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name) && list.get(i).getSurname().equalsIgnoreCase(surname)) {
                System.out.println(list.get(i));
                found = true;
            }
        } if (!found) {
            System.out.println("Pojištěný nenalezen");
        }
    }
}


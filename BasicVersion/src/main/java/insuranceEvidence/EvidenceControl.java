package insuranceEvidence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Třída EvidenceControl slouží ke správě evidence pojištěnců.
public class EvidenceControl {

    // List do kterého se jednotliví pojištěnci ukládají.
    private List<InsuredData> insuredEvidence = new ArrayList<>();
    private Scanner scanner;
    private UserInputValidation inputValidation;

    // Konstruktor k inicializaci potřebných závislotí.
    public EvidenceControl(Scanner scanner) {
        this.scanner = scanner;
        this.inputValidation = new UserInputValidation(scanner);
    }

    // Metoda k přidávání jednotlivých pojištěnců.
    public void addToEvidence() {
        String name = inputValidation.nameInput();
        String surname = inputValidation.surnameInput();
        String phoneNumber = inputValidation.phoneInput();
        int age = inputValidation.ageInput();

        insuredEvidence.add(new InsuredData(name, surname, phoneNumber, age));
    }

    // Metoda pro výpis célé evidence.
    public void showEntireEvidence() {
        for (int i = 0; i < insuredEvidence.size(); i++) {
            System.out.println(insuredEvidence.get(i));
        }
    }

    // Metoda pro výpis specifického pojištěnce podle jména a příjmení.
    public boolean showSingleEvidence(String name, String surname) {
        for (int i = 0; i < insuredEvidence.size(); i++) {
            if (insuredEvidence.get(i).getName().equalsIgnoreCase(name) && insuredEvidence.get(i).getSurname().equalsIgnoreCase(surname)) {
                System.out.println(insuredEvidence.get(i));
                return true;
            }
        }
        return false;
    }
}

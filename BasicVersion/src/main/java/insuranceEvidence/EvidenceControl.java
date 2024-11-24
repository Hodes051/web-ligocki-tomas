package insuranceEvidence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvidenceControl {
    private List<InsuredData> insuredEvidence = new ArrayList<>();
    private Scanner scanner;
    private UserInputValidation inputValidation;

    public EvidenceControl(Scanner scanner) {
        this.scanner = scanner;
        this.inputValidation = new UserInputValidation(scanner);
    }

    public void addToEvidence() {
        String name = inputValidation.nameInput();
        String surname = inputValidation.surnameInput();
        String phoneNumber = inputValidation.phoneInput();
        int age = inputValidation.ageInput();

        insuredEvidence.add(new InsuredData(name, surname, phoneNumber, age));
    }

    public void showEntireEvidence() {
        for (int i = 0; i < insuredEvidence.size(); i++) {
            System.out.println(insuredEvidence.get(i));
        }
    }

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

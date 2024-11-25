package insuranceEvidence;

import java.util.Scanner;

// Hlavní třída pro spouštění scanneru a samotného programu.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scanner);
        userInterface.getInterface();
    }
}

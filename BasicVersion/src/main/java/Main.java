import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Evidence evidence = new Evidence(scanner);
        UserInterface userInterface = new UserInterface(scanner, evidence);
        userInterface.getInterface();

        // TODO dopln popisky hlavo
    }
}

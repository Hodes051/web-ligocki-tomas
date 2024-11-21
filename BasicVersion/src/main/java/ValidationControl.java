import java.util.Scanner;

public class ValidationControl {
    private InsuredData insuredData;
    private Scanner scanner;

    private String getValidText(String text) {
        String validText;
        do {
            validText = scanner.nextLine().trim();
            if (insuredData.getName().isEmpty()) {
                System.out.println(text + " pojištěného je povinné");
            } else if (insuredData.getName().matches(".*\\d.*")) {
                System.out.println(text + " nesmí obsahovat číslice");
            }
        } while (insuredData.getName().isEmpty() || insuredData.getName().matches(".*\\d.*"));
        return validText;
    }
}
